import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS_인접리스트 {
	static int N, M, V;
	static LinkedList<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 탐색 시작 정점

		adjList = new LinkedList[1001]; // 정점의 개수가 1~1000
		visited = new boolean[1001];

		for (int i = 1; i <= 1000; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjList[from].add(to); // 양방향
			adjList[to].add(from);
		}
		for (int i = 1; i <= 1000; i++) { // 정렬
			Collections.sort(adjList[i]);
		}
		dfs(V);

		Arrays.fill(visited, false); // bfs탐색을 위해 방문배열 false로 바꾸기
		System.out.println();

		bfs(V);
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");

			for (int i = 0; i < adjList[current].size(); i++) { // 현재 정점이 인접해있는 수만큼
				if (!visited[adjList[current].get(i)]) {
					queue.offer(adjList[current].get(i));
					visited[adjList[current].get(i)] = true;
				}
			}
		}

	}

	public static void dfs(int start) {
		visited[start] = true; // 방문처리 먼저 해주고
		System.out.print(start + " ");

		for (int i = 0; i < adjList[start].size(); i++) { // 현재 정점이 인접해있는 수만큼
			if (!visited[adjList[start].get(i)]) { // 이미 방문한거 제외
				dfs(adjList[start].get(i));
			}
		}
	}

}
