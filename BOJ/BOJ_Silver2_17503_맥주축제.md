# 17503 맥주축제

날짜: 2023년 1월 11일
레벨: Silver
분류: 우선순위큐
상세레벨: Silver2

[17503번: 맥주 축제](https://www.acmicpc.net/problem/17503)

### 내 풀이

```jsx
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17503_맥주축제 {
	static int N, M, K;
	static Beer[] beer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		beer = new Beer[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			beer[i] = new Beer(v, c);
		}
		Arrays.sort(beer);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int sum = 0;
		int ans = -1;
		for (int i = 0; i < K; i++) {
			pq.add(beer[i].v); // 선호도 더하기
			sum += beer[i].v;
			if (pq.size() > N) { // 사이즈 초과하면 가장 작은 선호도 뺌
				sum -= pq.poll();
			}

			if (pq.size() == N && sum >= M) {
				ans = beer[i].c;
				break;
			}

		}
		System.out.println(ans);
	}

	static class Beer implements Comparable<Beer> {
		int v, c;

		public Beer(int v, int c) {
			super();
			this.v = v;
			this.c = c;
		}

		@Override
		public int compareTo(Beer o) {
			if (this.c == o.c) {
				return o.v - this.v;
			}
			return this.c - o.c;
		}
	}

}
```

- 처음에 조합으로 접근해서 풀었다가 시간초과남ㅜ
- 우선순위 큐 이용
    - 사이즈 초과하면 가장 작은 선호도 값 빼고
    - 사이즈 N과 똑같고 선호도의 합이 M보다 크거나 같을때 해당 도수 출력하는 식으로 품