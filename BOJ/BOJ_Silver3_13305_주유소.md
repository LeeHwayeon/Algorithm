# 주유소

날짜: 2023년 3월 16일
레벨: Silver3
분류: 그리디
언어: Java
출제기관: 백준

## 문제

[13305번: 주유소](https://www.acmicpc.net/problem/13305)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Silver3_13305_주유소 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 도시 개수
		long[] road = new long[N - 1];
		long[] oil = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < road.length; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < oil.length; i++) {
			oil[i] = Integer.parseInt(st.nextToken());
		}

		long ans = 0;
		long minOil = oil[0];
		for (int i = 0; i < oil.length - 1; i++) {
			minOil = Math.min(minOil, oil[i]); // 현재 주유소와 이전 주유소 비교
			ans += minOil * road[i];
		}
		System.out.println(ans);
	}
}
```

- 그리디는 현재 순간에서 최적의 상황을 찾는 것을 기억하자!
- 현재 주유소와 이전 주유소를 비교해서 더 싼 주유소 가격으로 계산