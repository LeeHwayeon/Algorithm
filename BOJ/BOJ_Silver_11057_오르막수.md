# 오르막수

날짜: 2023년 2월 8일
레벨: Silver1
분류: DP
언어: Java
출제기관: 백준

## 문제

[11057번: 오르막 수](https://www.acmicpc.net/problem/11057)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Silver1_11057_오르막수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 수의 길이
		int[][] dp = new int[N + 1][10];
		int[] result = new int[N + 1]; // N길이의 오르막 수 개수 총합을 담을 배열

		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1; // 수의 길이가 1일 경우에는 모두 경우의 수가 1임
			result[1] += dp[1][i];
		}

		// n : 수의 길이, j : 끝의 자리 수
		for (int n = 2; n <= N; n++) {
			dp[n][0] = 1;
			result[n] += dp[n][0];
			for (int j = 1; j < 10; j++) {
				dp[n][j] = (dp[n][j - 1] + dp[n - 1][j]) % 10007;
				result[n] += dp[n][j]; // 계산할때마다 n길이의 오르막 수 개수 더해주기
			}
		}

		System.out.println(result[N] % 10007);
	}

}
```

|  n \ j | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
| 2 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
| 3 | 1 | 3 | 6 | 10 | 15 | 21 | 28 | 36 | 45 | 55 |
| … |  |  |  |  |  |  |  |  |  |  |
| N | 1 |  |  |  |  |  |  |  |  |  |
- 표를 그려보면 이런식으로 나온다
    - n : 오르막 수의 길이
    - j : 맨 끝에 위치하는 숫자
- 계산식 `dp[n][j] = dp[n][j-1] + dp[n-1][j]` 를 도출할 수 있다
- 구해야하는 것은 오르막 수의 총 개수이므로 총 개수의 합을 저장할 result 배열을 생성해 준 뒤 계산할 때마다 `result[n] += dp[n][j]`를 해주면 된다.
- 그리고 `dp[n][j]`를 구할 때마다 `10007`로 나눠주면 됨