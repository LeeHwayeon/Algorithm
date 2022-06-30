import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
	static int M, N, H, tomato[][][], time;
	static Queue<Point> queue;
	static int di[] = { -1, 1, 0, 0, 0, 0 }; // 앞, 뒤, 좌, 우, 위, 아래
	static int dj[] = { 0, 0, -1, 1, 0, 0 };
	static int dh[] = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 열
		N = Integer.parseInt(st.nextToken()); // 행
		H = Integer.parseInt(st.nextToken()); // 높이
		tomato = new int[N][M][H];

		queue = new LinkedList<Point>();
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					tomato[i][j][h] = Integer.parseInt(st.nextToken());
					if (tomato[i][j][h] == 1) {
						queue.offer(new Point(i, j, h)); // 익은 토마토 좌표
					}
				}
			}
		}

		time = 0;
		bfs();

		boolean flag = true;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tomato[i][j][h] == 0) {
						flag = false;
						break;
					}
				}
			}
		}
		System.out.println(flag == true ? time : -1);
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				for (int d = 0; d < 6; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];
					int nexth = now.h + dh[d];
					if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && nexth >= 0 && nexth < H
							&& tomato[nexti][nextj][nexth] == 0) {
						tomato[nexti][nextj][nexth] = 1;
						queue.offer(new Point(nexti, nextj, nexth));
					}
				}
			}

			if (queue.size() > 0) {
				time++;
			}
		}
	}

	static class Point {
		int i, j, h;

		public Point(int i, int j, int h) {
			super();
			this.i = i;
			this.j = j;
			this.h = h;
		}
	}

}
