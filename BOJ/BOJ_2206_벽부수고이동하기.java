import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
	static int N, M, map[][], visited[][];
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s.charAt(j) + "");
				visited[i][j] = Integer.MAX_VALUE;
			}
		}

		int count = bfs(0, 0);
		System.out.println(count);
	}

	static int bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<Point>();
		visited[i][j] = 0; // 부신횟수
		queue.offer(new Point(i, j, 0, 1));

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			if (now.i + 1 == N && now.j + 1 == M) {
				return now.distance;
			}
			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];
				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && visited[nexti][nextj] > now.crush) {
					if (map[nexti][nextj] == 0) { // 벽 아닐때
						queue.offer(new Point(nexti, nextj, now.crush, now.distance + 1));
						visited[nexti][nextj] = now.crush;
					} else { // 벽
						if (now.crush == 0) { // 벽을 한번도 부순적 없을때
							queue.offer(new Point(nexti, nextj, now.crush + 1, now.distance + 1));
							visited[nexti][nextj] = now.crush + 1;
						}
					}
				}

			}
		}
		return -1;
	}

	static class Point {
		int i, j, crush, distance;

		public Point(int i, int j, int crush, int distance) {
			super();
			this.i = i;
			this.j = j;
			this.crush = crush;
			this.distance = distance;
		}

	}

}
