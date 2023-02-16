# 1학년

날짜: 2023년 2월 16일
레벨: Gold5
분류: DP
언어: Java
출제기관: 백준

## 문제

[5557번: 1학년](https://www.acmicpc.net/problem/5557)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Gold5_5557_1학년 {
	static int N, num[];
	static long dp[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		dp = new long[N][21];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		dp[0][num[0]] = 1; // 처음 수는 연산없이 바로 1

		for (int i = 1; i < N - 1; i++) { // i는 num배열의 인덱스
			for (int j = 0; j < 21; j++) { // j는 0부터 20이하
				if (dp[i - 1][j] != 0) { // 전에 연산을 했던적이 있는 수만 또 연산해주기
					int plus = j + num[i];
					if (plus >= 0 && plus <= 20) { 
						dp[i][plus] += dp[i - 1][j];
					}
					int minus = j - num[i];
					if (minus >= 0 && minus <= 20) {
						dp[i][minus] += dp[i - 1][j];
					}

				}
			}
		}
		// 뒤에서 두번째 인덱스에서 마지막 수의 값 출력
		System.out.println(dp[N - 2][num[N - 1]]); 
	}
}
```

- 처음에 dfs로 풀었는데 최대 2^98의 계산을 해줘야 하기 때문에 시간초과가 나서 맞는 방법이 아니다.
- DP로 접근해야하는데…
    - [여기](https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-5557-1%ED%95%99%EB%85%84-java)와 [이 블로그](https://dingdingmin-back-end-developer.tistory.com/entry/%EB%B0%B1%EC%A4%80-5557%EC%9E%90%EB%B0%94-java-1%ED%95%99%EB%85%84)를 참고했다..
    - `dp[0][num[0]](맨 처음 숫자)`는 연산을 하지 않기 때문에 1 대입
    - ex) N : 11,  num[] = { 8, 3, 2, 4, 8, 7, 2, 4, 0, 8, 8 }
        - dp[0][num[0]] = dp[0][8] = 1
        - 반복문
            - i가 1일경우를 예를 들어 설명하자면
                - `if(dp[i - 1][j] != 0)`는 즉, `dp[0][j] = dp[0][8] ≠ 0`
                    - 전에 연산을 했던 수만 +,- 연산을 해주는 것
                    - `dp[i][덧셈/뺄셈해서 나온 수] += dp[i-1][j];`