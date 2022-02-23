import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	public static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int T, M, N, K, map[][];
	static boolean[][] visited;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로길이
			N = Integer.parseInt(st.nextToken()); // 세로길이
			map = new int[M][N];
			visited = new boolean[M][N];

			K = Integer.parseInt(st.nextToken()); // 위치 개수
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}

			int cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
//						bfs(i, j);
						dfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	public static void bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(i, j));
		visited[i][j] = true; // 방문처리

		while (!queue.isEmpty()) {
			Point point = queue.poll();

			for (int d = 0; d < 4; d++) { // 상,하,좌,우로 비교
				int nexti = point.x + di[d];
				int nextj = point.y + dj[d];

				if (nexti >= 0 && nexti < M && nextj >= 0 && nextj < N && map[nexti][nextj] == 1
						&& !visited[nexti][nextj]) {
					queue.offer(new Point(nexti, nextj));
					visited[nexti][nextj] = true;
				}
			}

		}
	}

	public static void dfs(int i, int j) {
		visited[i][j] = true;

		for (int d = 0; d < 4; d++) {
			int nexti = i + di[d];
			int nextj = j + dj[d];

			if (nexti >= 0 && nexti < M && nextj >= 0 && nextj < N && map[nexti][nextj] == 1
					&& !visited[nexti][nextj]) {
				dfs(nexti, nextj);
			}
		}
	}

}
