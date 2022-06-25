import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	static int N, M, count;
	static boolean[] visited;
	static LinkedList<Integer>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		list = new LinkedList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<Integer>();
		}

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		bfs(1);
		System.out.println(count);
	}

	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(n);
		visited[n] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int now = queue.poll();

				for (int i = 0; i < list[now].size(); i++) {
					if (!visited[list[now].get(i)]) {
						queue.add(list[now].get(i));
						visited[list[now].get(i)] = true;
						count++;
					}
				}
			}
		}
	}

}
