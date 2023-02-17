import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_24444_알고리즘수업1 {
	static int N, M, R, visited[];
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점 수
		M = Integer.parseInt(st.nextToken()); // 간선 수
		R = Integer.parseInt(st.nextToken()); // 시작 정점

		visited = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}

		for (int i = 0; i < list.length; i++) {
			Collections.sort(list[i]);
		}

		bfs(R);
		for (int i = 1; i < visited.length; i++) {
			System.out.println(visited[i]);
		}
	}

	public static void bfs(int start) {
		int cnt = 1;
		visited[start] = cnt++;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 0; i < list[now].size(); i++) {
				int n = (int) list[now].get(i);
				if (visited[n] == 0) {
					queue.offer(n);
					visited[n] = cnt++;
				}
			}
		}
	}
}
