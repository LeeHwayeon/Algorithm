import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {
	static int T, N, M, R, C, L, map[][], cnt;
	static boolean[][] visited;
	static int[] di = { -1, 0, 1, 0 }; // 상, 우, 하, 좌
	static int[] dj = { 0, 1, 0, -1 };
	static int[][] tunnel = { {}, { 1, 1, 1, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 0 },
			{ 0, 0, 1, 1 }, { 1, 0, 0, 1 } };

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 행
			M = Integer.parseInt(st.nextToken()); // 열
			R = Integer.parseInt(st.nextToken()); // 맨홀뚜껑 행
			C = Integer.parseInt(st.nextToken()); // 맨홀뚜껑 열
			L = Integer.parseInt(st.nextToken()); // 탈출 소요 시간

			map = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 1; // 처음 맨홀뚜껑도 포함
			bfs();

			System.out.println("#" + t + " " + cnt);
		}
	}

	public static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(R, C));
		visited[R][C] = true;

		int time = 1; // 큐에 넣을때 이미 1시간 소요
		while (!queue.isEmpty()) {
			if (time >= L) // 제한 시간 다 되면 끝
				break;

			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();

				for (int d = 0; d < 4; d++) {
					if (tunnel[map[now.x][now.y]][d] == 1) { // 현재 위치에서 d방향이 뚫려있는지
						int nexti = now.x + di[d];
						int nextj = now.y + dj[d];

						if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && map[nexti][nextj] != 0
								&& !visited[nexti][nextj]) {
							if (tunnel[map[nexti][nextj]][(d + 2) % 4] == 1) { // 다음 칸의 현재방향(d)의 반대방향(d+2)%4가 뚫려있는지 확인
								queue.offer(new Point(nexti, nextj));
								visited[nexti][nextj] = true;
								cnt++;
							}
						}
					}
				}
			}
			time++;
		}
	}

}