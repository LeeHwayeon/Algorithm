import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {
	static int N, M, start, arrive;
	static boolean[] visited;
	static ArrayList[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		arrive = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}

		System.out.println(search(start));
	}

	public static int search(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(n);
		visited[n] = true;
		int count = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int now = queue.poll();
				if (now == arrive) {
					return count;
				}
				for (int i = 0; i < list[now].size(); i++) {
					if (!visited[(int) list[now].get(i)]) {
						queue.offer((Integer) list[now].get(i));
						visited[(int) list[now].get(i)] = true;
					}
				}
			}
			count++;
		}
		return -1;
	}

}
