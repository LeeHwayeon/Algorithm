import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
	static int map[][], w, h;
	static boolean[][] visited;
	static int[] di = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dj = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = "";
		while ((st = br.readLine()) != null) {
			StringTokenizer line = new StringTokenizer(st);
			w = Integer.parseInt(line.nextToken()); // 너비 = 열
			h = Integer.parseInt(line.nextToken()); // 높이 = 행
			if (w == 0 && h == 0) {
				break; // 마지막 줄 0 0 들어올때 반복문 종료
			}
			map = new int[h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				line = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(line.nextToken());
				}
			}

			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) { // 땅이면서 방문안했을때만
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
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { i, j });
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int d = 0; d < 8; d++) { // 가로,세로,대각선
				int nexti = now[0] + di[d];
				int nextj = now[1] + dj[d];

				if (nexti >= 0 && nexti < h && nextj >= 0 && nextj < w && !visited[nexti][nextj]
						&& map[nexti][nextj] == 1) {
					queue.offer(new int[] { nexti, nextj });
					visited[nexti][nextj] = true;
				}
			}
		}

	}

	public static void dfs(int i, int j) {
		visited[i][j] = true;
		for (int d = 0; d < 8; d++) { // 가로,세로,대각선
			int nexti = i + di[d];
			int nextj = j + dj[d];

			if (nexti >= 0 && nexti < h && nextj >= 0 && nextj < w && !visited[nexti][nextj]
					&& map[nexti][nextj] == 1) {
				dfs(nexti, nextj);
			}
		}

	}

}
