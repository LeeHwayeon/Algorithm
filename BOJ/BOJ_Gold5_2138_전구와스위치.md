# 전구와 스위치

날짜: 2023년 2월 14일

## 문제

[2138번: 전구와 스위치](https://www.acmicpc.net/problem/2138)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_Gold5_2138_전구와스위치 {
	static int N, min;
	static char[] nowStatus, makeStatus;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nowStatus = br.readLine().toCharArray();
		makeStatus = br.readLine().toCharArray();
		min = Integer.MAX_VALUE;

		// 0번 스위치 안 눌렀을 때
		char[] newArray = Arrays.copyOf(nowStatus, N);
		pressCount(newArray, 0);

		// 0번 스위치 눌렀을 때 : 0,1번 스위치 반전
		char[] newArray2 = Arrays.copyOf(nowStatus, N);
		newArray2[0] = switchStatus(nowStatus, 0);
		newArray2[1] = switchStatus(nowStatus, 1);
		pressCount(newArray2, 1);

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}

	// 스위치 누르는 횟수 세기
	static void pressCount(char[] str, int cnt) {
		for (int i = 1; i < N; i++) {
			if (str[i - 1] != makeStatus[i - 1]) { // 전 인덱스의 값이 다를 경우 스위치 누르기
				cnt++; // 스위치 횟수 증가
				if (i - 1 >= 0) // i-1
					str[i - 1] = switchStatus(str, i - 1);
				str[i] = switchStatus(str, i); // i
				if (i + 1 < N) // i+1
					str[i + 1] = switchStatus(str, i + 1);
			}
		}
		if (String.valueOf(str).equals(String.valueOf(makeStatus))) { // 만들고자 하는 상태와 같을 경우
			min = Math.min(min, cnt);
		}
	}

	// 전구 상태 반전시키기
	static char switchStatus(char[] str, int index) {
		if (str[index] == '0') {
			return '1';
		}
		return '0';
	}

}

```

- 처음에는 dfs로 처음부터 눌렀을 때, 안눌렀을 때 둘 다 따지면서 하니 메모리 초과
    - `2^100000` 계산을 해야하니 당연히 초과하는 것ㅎ
- 그래서 현재 자리는 현재 자리가 바뀌던가 다음 자리가 바꼈을때만 영향을 받으니
    - 0번째를 눌렀을때, 안눌렀을때를 각각 비교하기로 함 ⇒ 앞부터 똑같아야 하니까
    - 1 ~ N까지 현재 인덱스의 앞자리가 같은지 같지 않은지 비교
    - 이렇게 해도 메모리 초과가 난다…
- **메모리 초과**가 나는 이유..?
    - 문자열이 같은지 비교해야하니까 매번 스위치 눌러서 값이 바뀔때마다 새로운 문자열을 생성하는 식으로 풀었음 ⇒ 새로운 String 객체를 매번 생성하니까 불필요한 메모리 낭비
    - `i-1`, `i`, `i+1`을 제외한 앞 뒤 문자열을 `substring()`메서드로 이어 붙여줌
        - `substring()` 메서드를 사용하는 방법의 문제점은 새로운 문자열 객체를 Heap 영역에 생성하므로 메모리 낭비가 발생하며, 가비지 컬렉션이 처리해야 하는 작업이 늘어난다는 것
    - 그래서 문자열을 toCharArray로 배열로 바꿔서 계산함 ⇒ 통과!!!
