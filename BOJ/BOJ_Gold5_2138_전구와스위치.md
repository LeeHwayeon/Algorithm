# 전구와 스위치

날짜: 2023년 2월 14일

## 문제

[2138번: 전구와 스위치](https://www.acmicpc.net/problem/2138)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Gold5_2138_전구와스위치 {
	static int N, max;
	static String nowStatus, makeStatus;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nowStatus = br.readLine();
		makeStatus = br.readLine();
		max = -2;

		// 0번 스위치 안 눌렀을 때
		pressCount(nowStatus, 0);

		// 0번 스위치 눌렀을 때
		String str = switchStatus(nowStatus, 0) + switchStatus(nowStatus, 1);
		str += N > 2 ? nowStatus.substring(2, N) : "";
		pressCount(str, 1);

		System.out.println(max);

	}

	static void pressCount(String str, int cnt) {
		for (int i = 1; i < N; i++) {
			if (str.charAt(i - 1) != makeStatus.charAt(i - 1)) { // 전 인덱스의 값이 다를 경우 스위치 누르기
				cnt++;
				String start = i - 1 >= 0 ? str.substring(0, i - 1) : "";
				String one = i - 1 >= 0 ? switchStatus(str, i - 1) : "";
				String two = switchStatus(str, i);
				String three = i + 1 < N ? switchStatus(str, i + 1) : "";
				String end = i + 2 < N ? str.substring(i + 2, N) : "";
				str = start + one + two + three + end;
			}
		}
		if (str.equals(makeStatus)) { // 만들고자 하는 상태와 같을 경우
			max = Math.max(cnt, max);
		} else { // 불가능한 경우
			max = -1;
		}
	}

	static String switchStatus(String str, int index) {
		if (str.charAt(index) == '0') {
			return "1";
		}
		return "0";
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