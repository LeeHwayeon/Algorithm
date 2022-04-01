import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지_BFS {
	static int N;
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };

	public static class Point implements Comparable<Point> {
		int x, y, cost;

		public Point(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int idx = 1; // 출력 형식을 위한 변수
		while (N != 0) {
			int[][] map = new int[N][N];
			int[][] visited = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					visited[i][j] = Integer.MAX_VALUE; // 큰 값으로 채워넣기
				}
			}

			System.out.println("Problem " + idx + ": " + bfs(map, 0, 0, visited));

			N = Integer.parseInt(br.readLine());
			idx++;
		}
	}

	public static int bfs(int[][] map, int i, int j, int[][] visited) {
		PriorityQueue<Point> queue = new PriorityQueue<Point>();
		queue.offer(new Point(i, j, map[i][j]));
		visited[i][j] = map[i][j];

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			if (now.x == N - 1 && now.y == N - 1) {
				return now.cost;
			}

			for (int d = 0; d < 4; d++) {
				int nexti = now.x + di[d];
				int nextj = now.y + dj[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N) { // 유효하고
					if (visited[nexti][nextj] > now.cost + map[nexti][nextj]) { // 기존의 visited값보다 작을때만 큐에 집어 넣기
						queue.offer(new Point(nexti, nextj, now.cost + map[nexti][nextj]));
						visited[nexti][nextj] = now.cost + map[nexti][nextj];
					}
				}
			}
		}
		return 0;
	}
}
