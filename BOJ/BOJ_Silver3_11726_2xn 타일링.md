# 2xn 타일링

날짜: 2023년 2월 7일
레벨: Silver3
분류: DP
언어: Java
출제기관: 백준

## 문제

[11726번: 2×n 타일링](https://www.acmicpc.net/problem/11726)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Silver3_11726_2xn타일링 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
		System.out.println(dp[n] % 10007);
	}

}
```

- 처음에 도형 규칙을 잘못 구해서 점화식을 못 찾았다..
- 도형 규칙 잘 찾는 것 중요할듯…