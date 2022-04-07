import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1249_보급로 {
	static int map[][], cnt[][], N, min;
	static int[] di = { 1, 0, 0, -1 };
	static int[] dj = { 0, 1, -1, 0 };

	public static class Point {
		int x, y, time;

		public Point(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cnt = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(s.charAt(j) + "");
					cnt[i][j] = Integer.MAX_VALUE;
				}
			}
			bfs(0, 0);
			System.out.println("#" + t + " " + cnt[N - 1][N - 1]);
		}
	}

	public static void bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(i, j, map[i][j]));
		cnt[i][j] = map[i][j];

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nexti = now.x + di[d];
				int nextj = now.y + dj[d];

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N)
					continue;

				if (cnt[nexti][nextj] <= now.time + map[nexti][nextj])
					continue;

				cnt[nexti][nextj] = map[nexti][nextj] + now.time;
				queue.offer(new Point(nexti, nextj, cnt[nexti][nextj]));

			}

		}

	}

}