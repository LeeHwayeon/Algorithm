# 도시분할계획

날짜: 2023년 2월 3일
레벨: Gold4
분류: MST
언어: Java
출제기관: 백준

## 문제

[1647번: 도시 분할 계획](https://www.acmicpc.net/problem/1647)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {
	static int N, M, parents[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Edge[] edge = new Edge[M];
		parents = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edge[i] = new Edge(from, to, weight);
		}
		Arrays.sort(edge);
		makeParent();

		int result = 0;
		int cnt = 0;

		for (Edge e : edge) {
			if (union(e.from, e.to)) {
				result += e.weight;
				if (++cnt == N - 2) // 한개의 집만 있어도 마을이 되기 때문에
					break;
			}
		}
		System.out.println(result);

	}

	static void makeParent() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	static int findParent(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = findParent(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findParent(a);
		int bRoot = findParent(b);
		if (aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
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

- 크루스칼 알고리즘을 이용해서 푼 최소 스패닝 트리 문제
- `마을에는 집이 하나 이상 있어야 한다 = 마을에 집이 하나만 있어도 된다` 이므로 비용이 제일 큰 마지막 간선을 빼주면 됨
    - 즉 N-1개의 간선을 연결하는 것을 N-2개로 줄여줌