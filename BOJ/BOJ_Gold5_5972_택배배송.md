# 택배배송

날짜: 2023년 2월 3일
레벨: Gold5
분류: 다익스트라
언어: Java
출제기관: 백준

## 문제

[5972번: 택배 배송](https://www.acmicpc.net/problem/5972)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_5972_택배배송 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 헛간
		int M = Integer.parseInt(st.nextToken()); // 길

		boolean[] visited = new boolean[N + 1];
		int[] minD = new int[N + 1];
		Arrays.fill(minD, 50000 * 1000 + 1);

		ArrayList<Edge>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Edge(to, weight));
			list[to].add(new Edge(from, weight));
		}

		minD[1] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1, minD[1]));

		while (!pq.isEmpty()) {
			Edge now = pq.poll();

			if (visited[now.to])
				continue;
			visited[now.to] = true;

			for (Edge next : list[now.to]) {
				if (minD[next.to] > minD[now.to] + next.weight) {
					minD[next.to] = minD[now.to] + next.weight;
					pq.add(new Edge(next.to, minD[next.to]));
				}
			}
		}

		System.out.println(minD[N]);
	}

	static class Edge implements Comparable<Edge> {
		int to, weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

}
```

- 최댓값 설정 시 간선 가중치의 `최댓값 * 정점 개수 + 1` 로 설정해줘야함