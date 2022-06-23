import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
	static int N, M, map[][], count;
	static boolean visited[][];
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s.charAt(j) + "");
			}
		}

		bfs(0, 0);
		System.out.println(count + 1);
	}

	public static void bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(i, j));
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();

				if (now.i == N - 1 && now.j == M - 1) {
					return;
				}

				for (int d = 0; d < 4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];

					if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && !visited[nexti][nextj]
							&& map[nexti][nextj] == 1) {
						queue.offer(new Point(nexti, nextj));
						visited[nexti][nextj] = true;
					}
				}
			}
			count++;
		}
	}

	public static class Point {
		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

	}

}
