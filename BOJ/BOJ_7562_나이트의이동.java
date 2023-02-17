import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {
	static int T, I;
	static boolean map[][];
	static Point start, arrive;
	static int di[] = { -2, -1, 1, 2, 2, 1, -1, -2 }; // 시계방향
	static int dj[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); // 테케
		for (int t = 0; t < T; t++) {
			I = Integer.parseInt(br.readLine());
			map = new boolean[I][I];
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			arrive = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			System.out.println(bfs(start.i, start.j));
		}
	}

	static int bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(i, j));
		map[i][j] = true;

		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();

				if (now.i == arrive.i && now.j == arrive.j) {
					return count;
				}
				for (int d = 0; d < 8; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];
					if (nexti >= 0 && nexti < I && nextj >= 0 && nextj < I && !map[nexti][nextj]) {
						queue.offer(new Point(nexti, nextj));
						map[nexti][nextj] = true;
					}
				}
			}
			count++;
		}
		return -1;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

}
