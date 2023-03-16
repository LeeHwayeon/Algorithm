# 기타줄

날짜: 2023년 3월 16일
레벨: Silver4
분류: 그리디
언어: Java
출제기관: 백준

## 문제

[1049번: 기타줄](https://www.acmicpc.net/problem/1049)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Silver4_1049_기타줄 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 끊어진 기타줄 개수
		int M = Integer.parseInt(st.nextToken()); // 기타줄 브랜드

		int pack = 1000;
		int one = 1000;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pack = Math.min(pack, a);
			one = Math.min(one, b);
		}

		int remain = N % 6;
		int mok = N / 6;
		int sum = one * N; // 낱개
		sum = Math.min(sum, (mok * pack) + (remain * one)); // 패키지 + 낱개
		sum = Math.min(sum, remain != 0 ? (mok + 1) * pack : mok * pack); // 패키지
		System.out.println(sum);
	}
}
```

- 낱개, 패키지, 낱개+패키지 모두를 계산해서 가장 적은 값을 출력