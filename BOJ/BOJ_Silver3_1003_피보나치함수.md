# 피보나치함수

날짜: 2023년 2월 7일
레벨: Silver3
분류: DP
언어: Java
출제기관: 백준

## 문제

[1003번: 피보나치 함수](https://www.acmicpc.net/problem/1003)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Silver3_1003_피보나치함수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[41][2];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			if (N < 2) {
				System.out.println(dp[N][0] + " " + dp[N][1]);
				continue;
			}

			for (int i = 2; i <= N; i++) {
				if (dp[i][0] == 0 && dp[i][1] == 0) {
					dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
					dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
				}
			}
			System.out.println(dp[N][0] + " " + dp[N][1]);
		}
	}
}
```

- 2차원 배열을 만들어 `dp[i][0]`은 0의 출력 횟수 `dp[i][1]`은 1 출력 횟수로 생각해 계산해 줌
- 테케 실행 중 이미 갱신된 `dp[i][]`의 값을 또 계산하는 일이 없게 `dp[i][0] == 0 && dp[i][1] == 0` 일때만 계산을 해주도록 함