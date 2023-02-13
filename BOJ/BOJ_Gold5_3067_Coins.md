# Coins

날짜: 2023년 2월 13일
레벨: Gold5
분류: DP
언어: Java
출제기관: 백준

## 문제

[3067번: Coins](https://www.acmicpc.net/problem/3067)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Gold5_3067_Coins {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine()); // 동전 가지 수
			int[] coins = new int[N]; // 동전

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				coins[n] = Integer.parseInt(st.nextToken());
			}

			int M = Integer.parseInt(br.readLine()); // 만들어야 할 금액
			int[] dp = new int[M + 1];

			for (int n = 0; n < N; n++) {
				dp[coins[n]]++; // 현재 동전 금액 coins[n] 하나로도 금액을 만들 수 있음
				for (int i = coins[n]; i <= M; i++) {
					// 만들어야할 금액 i에서 현재 동전 금액 coins[n]을 뺀 금액의 경우의 수를 더해주기
					dp[i] += dp[i - coins[n]];
				}
			}
			System.out.println(dp[M]);
		}
	}

}
```

- 2,3,5원의 동전이 있고 만들어야 할 금액이 10인경우

|  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 2원 | 0 | 1 | 0 | 1 | 0 | 1 | 0 | 1 | 0 | 1 |

|  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 3원 | 0 | 1 | 1 | 1 | 1 | 2 | 1 | 2 | 2 | 2 |

|  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 5원 | 0 | 1 | 1 | 1 | 2 | 2 | 2 | 3 | 3 | 4 |