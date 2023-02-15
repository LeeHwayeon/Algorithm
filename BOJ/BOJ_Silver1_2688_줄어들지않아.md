# 줄어들지않아

날짜: 2023년 2월 14일
레벨: Silver1
분류: DP
언어: Java
출제기관: 백준

## 문제

[2688번: 줄어들지 않아](https://www.acmicpc.net/problem/2688)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Silver1_2688_줄어들지않아 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		long[] count = new long[65];
		long[][] dp = new long[65][10];
		for (int i = 0; i < 10; i++) { // 1자리는 모두 1개
			dp[1][i] = 1;
			count[1] += dp[1][i];
		}
		for (int i = 2; i <= 64; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0)
					dp[i][j] = 1; // 0일경우 1개
				else
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				count[i] += dp[i][j];
			}
		}

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(count[N]);
		}
	}

}
```

- [오르막수](https://www.acmicpc.net/problem/11057)랑 말만 다르지 똑같은 문젠데 대체 왜 25%에서 틀렸다고 나오지?
    - 오르막수는 매번 10007로 나눈 나머지를 저장해주기 때문에 int범위 넘어갈 일이 없었지만 줄이들지 않아는 계속 더해주기 때문에 int → long으로 바꿔야 함