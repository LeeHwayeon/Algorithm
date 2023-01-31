# 1922_네트워크 연결

날짜: 2023년 1월 2일
레벨: Gold
분류: MST
상세레벨: Gold4

[1922번: 네트워크 연결](https://www.acmicpc.net/problem/1922)

### 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크연결 {
	static int N, M, parents[];
	static Edge[] edge;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		edge = new Edge[M];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edge[i] = new Edge(from, to, weight);
		}

		int sum = 0;
		int count = 0;

		makeSet();
		Arrays.sort(edge);
		for (Edge e : edge) {
			if (union(e.from, e.to)) {
				sum += e.weight;
				if (++count == N - 1)
					break;
			}
		}
		System.out.println(sum);
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

	static void makeSet() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

}
```

- 최소신장트리의 크루스칼 알고리즘 이용하는 기본 문제