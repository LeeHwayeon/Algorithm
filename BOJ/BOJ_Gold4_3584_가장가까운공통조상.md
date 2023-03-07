# 가장 가까운 공통 조상

날짜: 2023년 3월 7일
레벨: Gold4
분류: 트리
언어: Java
출제기관: 백준

## 문제

[3584번: 가장 가까운 공통 조상](https://www.acmicpc.net/problem/3584)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Gold4_3584_가장가까운공통조상 {
	static int N;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer> aList, bList;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList[N + 1];

			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}

			StringTokenizer st = null;
			for (int i = 0; i < N - 1; i++) { // 간선 연결
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[b].add(a); // 자식 -> 부모
			}

			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // 가장 가까운 공통 조상 구할 노드
			int B = Integer.parseInt(st.nextToken());

			visited = new boolean[N + 1]; // 해당 정점 방문했는지
			int ans = 0; // 공통 조상 노드

			Queue<Integer> queue = new LinkedList<>();
			queue.add(A);
			visited[A] = true;
			while (!queue.isEmpty()) { // A노드는 모든 조상을 찾아서 방문처리
				int now = queue.poll();

				for (int next : list[now]) {
					queue.add(next);
					visited[next] = true;
				}
			}

			queue.add(B);
			while (true) {
				int now = queue.poll();
				if (visited[now]) { // 방문했다 = 공통 조상 발견
					ans = now;
					break;
				} else { // 방문안한 조상 노드는 방문처리
					visited[now] = true;
				}
				for (int next : list[now]) {
					queue.add(next);
				}
			}
			System.out.println(ans);

		}
	}
}
```

- “A가 B의 부모이다”라는 조건이 있어서 자식 → 부모로 올라갈 수 있게 단방향으로 연결
- A, B의 가장 가까운 공통 조상을 찾기 위해서
    - 먼저 A 노드를 탐색하면서 찾을 수 있는 모든 조상을 방문처리 해준다
    - 그 다음 B 노드를 탐색할때엔 현재 노드가 이미 방문되어 있으면 가장 가까운 공통 조상 발견한 것, 만약 방문하지 않았을 경우에는 그 위의 조상 찾기를 수행해준다
- 다른 풀이를 찾아보니 LCA 알고리즘으로 많이 풀더라.. LCA 알고리즘을 몰라서 난 그냥 생각나는 대로 풀이했다ㅎ