# 도서관

날짜: 2023년 3월 20일
레벨: Gold5
분류: 그리디
언어: Java
출제기관: 백준

## 문제

[1461번: 도서관](https://www.acmicpc.net/problem/1461)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_Gold5_1461_도서관 {
	static int ans, N, M, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 책 개수
		M = Integer.parseInt(st.nextToken()); // 한번에 들 수 있는 책 개수

		PriorityQueue<Integer> plus = new PriorityQueue<>((a, b) -> b - a); // 양수
		PriorityQueue<Integer> minus = new PriorityQueue<>((a, b) -> b - a); // 음수

		st = new StringTokenizer(br.readLine());
		max = 0;
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			if (now < 0) {
				minus.add(now * -1);
			} else {
				plus.add(now);
			}
			max = Math.max(max, now < 0 ? now * -1 : now);
		}

		ans = 0;
		calcu(plus);
		calcu(minus);
		System.out.println(ans -= max);
	}

	static void calcu(PriorityQueue<Integer> pq) {
		while (!pq.isEmpty()) {
			int now = pq.poll(); // 큰 값 먼저 뽑기
			for (int i = 0; i < M - 1; i++) { // 들 수 있는 만큼 책 더 뽑기
				pq.poll();
				if (pq.isEmpty())
					break;
			}
			ans += now * 2; // 왕복
		}
	}

}
```

- 책을 최소 걸음수로 다시 제자리에 놔둬야 하기 때문에 양수, 음수 책들을 각각 내림차순으로 pq에 담아준다.
- 책의 위치가 큰값을 기준으로 M개 만큼 들고가서 0으로 다시와야 하기 때문에 왕복으로 걸음 수를 계산해주고, 책을 모두 제자리에 놔둔 후에는 다시 0으로 돌아올 필요가 없기 때문에 걸음 수를 최소로 만드려면 가장 큰 값의 위치에 있는 책을 제자리에 둘 때 다시 0으로 돌아오는 것을 빼주면 되기 때문에 max를 기록해서 마지막에 빼준다