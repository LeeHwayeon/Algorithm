import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	static int N, M, map[][], max;
	static ArrayList<Point> virus, wall;
	static boolean isSelected[];
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열

		map = new int[N][M];
		virus = new ArrayList<Point>(); // 바이러스 저장할 리스트
		wall = new ArrayList<Point>(); // 빈칸 저장할 리스트
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new Point(i, j));
				} else if (map[i][j] == 0) {
					wall.add(new Point(i, j));
				}
			}
		}

		isSelected = new boolean[wall.size()];
		max = -1;

		combi(0, 0);

		System.out.println(max);
	}

	public static int spreadVirus(int[][] safe) {
		Queue<Point> queue = new LinkedList<Point>();
		for (int i = 0; i < virus.size(); i++) { // 바이러스 위치 큐에 넣기
			queue.offer(new Point(virus.get(i).x, virus.get(i).y));
		}

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nexti = now.x + di[d];
				int nextj = now.y + dj[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && safe[nexti][nextj] == 0) {
					queue.offer(new Point(nexti, nextj));
					safe[nexti][nextj] = safe[now.x][now.y];
				}
			}
		}
		return safeArea(safe);
	}

	public static int safeArea(int[][] safe) { // 안전영역이 몇 개인지
		int cnt = 0;
		for (int[] mm : safe) {
			for (int m : mm) {
				if (m == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void combi(int cnt, int idx) { // 빈칸 중에 3개 뽑아서 벽으로 만들기
		if (cnt == 3) {
			int[][] safe = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					safe[i][j] = map[i][j]; // map 복사
				}
			}
			for (int i = 0; i < wall.size(); i++) {
				if (isSelected[i]) {
					safe[wall.get(i).x][wall.get(i).y] = 1; // 벽으로 만들기
				}
			}
			int safeCnt = spreadVirus(safe); // 바이러스 퍼뜨리기
			max = Math.max(max, safeCnt);
			return;
		}

		if (idx == wall.size()) {
			return;
		}

		isSelected[idx] = true;
		combi(cnt + 1, idx + 1);
		isSelected[idx] = false;
		combi(cnt, idx + 1);
	}

}