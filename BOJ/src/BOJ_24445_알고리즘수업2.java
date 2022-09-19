import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_24445_알고리즘수업2 {
	static int N, M, R, visited[];
	static ArrayList[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		visited = new int[N + 1];
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}

		for (int i = 1; i < list.length; i++) {
			Collections.sort(list[i], Collections.reverseOrder());
		}

		bfs(R);

		for (int i = 1; i < visited.length; i++) {
			System.out.println(visited[i]);
		}
	}

	public static void bfs(int num) {
		int idx = 1;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(num);
		visited[num] = idx++;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 0; i < list[now].size(); i++) {
				int tmp = (int) list[now].get(i);
				if (visited[tmp] == 0) {
					queue.add(tmp);
					visited[tmp] = idx++;
				}
			}
		}
	}
}
