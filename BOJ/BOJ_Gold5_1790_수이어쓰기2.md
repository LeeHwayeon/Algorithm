# 수 이어 쓰기2

날짜: 2023년 2월 17일
레벨: Gold5
분류: 구현
언어: Java
출제기관: 백준

## 문제

[1790번: 수 이어 쓰기 2](https://www.acmicpc.net/problem/1790)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Gold5_수이어쓰기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // N까지 수 이어 쓰기
		int k = Integer.parseInt(st.nextToken()); // k번째 자리 숫자

		int length = 1; // 자릿수
		int realNum = 0; // k가 포함된 실제숫자
		while (true) {
			int cnt = (int) (length * Math.pow(10, length - 1) * 9);
			if (k - cnt < 0) {
				break;
			}
			realNum += Math.pow(10, length - 1) * 9; // 현재길이의 가장 끝자리수를 만들기
			k -= cnt; // 해당하는 자리 수가 아니니까 빼줘야함
			length++; // 자리 수 증가
		}

		int remain = k % length;

		if (remain == 0) {
			realNum += k / length;
		} else {
			realNum += k / length + 1; // 나머지가 있는건 현재수의 그 다음수에 k가 있다는 것
		}

		if (N < realNum) { // k번째 숫자를 포함한 실제 숫자가 N보다 작으면
			System.out.println(-1);
			return;
		}

		String strRealNum = String.valueOf(realNum);
		if (remain == 0) { // 나머지가 0이면 마지막 숫자 출력
			System.out.println(strRealNum.charAt(strRealNum.length() - 1));
		} else {
			System.out.println(strRealNum.charAt(remain - 1));
		}

	}

}
```

- 처음에 1부터 N까지 현재 숫자의 인덱스를 빼주면서 총 인덱스 길이가 k보다 크거나 같을때 break 걸어서 빠져나오는 식으로 풀이했는데 메모리 초과
    1. k번째 자리 숫자가 포함되는 실제 숫자의 길이를 구하기
        1. 현재 숫자 길이의 인덱스 총 합을 구해서 k보다 작으면 자리수 증가, k에서 합 빼주면서 반복
    2. 실제 숫자는 자리수에서 인덱스/자리수를 더하고 -1을 한 값
    3. 만약 실제 숫자가 N보다 클 경우 k번째 수를 구할 수 없음
        1. 아닐 경우 나머지가 0이면 맨 뒷자리 출력, 나머지가 있으면 나머지-1자리 출력
    - 3%에서 틀렸다고 나옴..
- `현재 길이의 가장 끝 자리수`를 만드는 것이 포인트인 것 같은 문제
    - `length` : 현재 자리 수
    - `realNum` : k번째 자리 숫자가 포함되어 있는 실제 수
    - 반복문
        - `cnt` : 현재 자리수에서 나올 수 있는 총 인덱스 수
        - 만약 k에서 cnt를 뺀 값이 0보다 작을 경우 더 큰 수로 갈 수가 없음
    - 나는 맨 처음 풀이에서 `10부터 기준`이라고 생각해 실제 자리수를 구할때 -1을 해줬음
        - 여기서는 `현재길이의 가장 끝 자리수`를 기준으로 생각하니까 -1을 할 필요없이 실제 숫자에 k/length를 더해주면 됨
        - 또한 만약 `k%length ≠ 0` 일경우는 현재 숫자에서 +1을 한 곳에 k번째 수가 있다는 소리니 realNum+1을 해주면 됨
- 결론 : 개인적으로 생각보다 까다로운 수학?구현?문제였던거 같다… 수많은 틀렸습니다를 마주함