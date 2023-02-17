import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18405_경쟁적전염 {
	static int N, K, map[][], S, X, Y;
	static PriorityQueue<Point> pq;
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 맵 크기
		K = Integer.parseInt(st.nextToken()); // 바이러스 최대 번호

		map = new int[N][N];
		pq = new PriorityQueue<Point>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					pq.offer(new Point(i, j, map[i][j], 0));
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken()); // 시간
		X = Integer.parseInt(st.nextToken()) - 1;
		Y = Integer.parseInt(st.nextToken()) - 1;

		System.out.println(spread());
	}

	static int spread() {
		while (!pq.isEmpty()) {
			Point now = pq.poll();

			if (now.time == S) {
				return map[X][Y];
			}

			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && map[nexti][nextj] == 0) {
					map[nexti][nextj] = now.virus;
					pq.offer(new Point(nexti, nextj, map[nexti][nextj], now.time + 1));
				}
			}
		}
		return map[X][Y];
	}

	static class Point implements Comparable<Point> {
		int i, j, virus, time;

		public Point(int i, int j, int virus, int time) {
			super();
			this.i = i;
			this.j = j;
			this.virus = virus;
			this.time = time;
		}

		@Override
		public int compareTo(Point o) { // 시간 같으면 바이러스 작은순, 아니면 시간순
			return this.time == o.time ? this.virus - o.virus : this.time - o.time;
		}
	}

}
