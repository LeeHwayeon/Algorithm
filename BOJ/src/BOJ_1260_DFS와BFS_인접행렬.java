import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS_인접행렬 {
	static int N, M, V, adjMatrix[][];
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 탐색 시작 정점

		adjMatrix = new int[1001][1001]; // 정점의 개수가 1~1000
		visited = new boolean[1001];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
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

			for (int i = 0; i < adjMatrix.length; i++) { // 현재 정점이 인접해있는 수만큼
				if (!visited[i] && adjMatrix[current][i] != 0) { // 방문안했고 0이아닌경우
					queue.offer(i);
					visited[i] = true;
				}
			}
		}

	}

	public static void dfs(int start) {
		visited[start] = true; // 방문처리 먼저 해주고
		System.out.print(start + " ");

		for (int i = 0; i < adjMatrix.length; i++) { // 현재 정점이 인접해있는 수만큼
			if (!visited[i] && adjMatrix[start][i] != 0) { // 이미 방문한거 제외
				dfs(i);
			}
		}
	}

}
