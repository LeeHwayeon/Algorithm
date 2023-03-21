# 카드 합체 놀이

날짜: 2023년 3월 21일
레벨: Silver1
분류: 우선순위큐
언어: Java
출제기관: 백준

## 문제

[15903번: 카드 합체 놀이](https://www.acmicpc.net/problem/15903)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_Silver1_15903_카드합체놀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 카드 수
		int m = Integer.parseInt(st.nextToken()); // m번의 카드 합체

		PriorityQueue<Long> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}

		while (m != 0) {
			long x = pq.poll();
			long y = pq.poll();
			for (int i = 0; i < 2; i++) {
				pq.add(x + y);
			}
			m--;
		}

		long ans = 0;
		while (!pq.isEmpty()) {
			ans += pq.poll();
		}
		System.out.println(ans);
	}
}
```

- 점수를 작게 만들기 위해서는 가장 작은 두 수를 뽑아 더하는 것
- 이 문제에서 주의할점은 범위이다.
    - n은 1000까지, m은 15*n까지, a는 1,000,000이기 때문에 다 더한다면 int범위를 넘어설 것