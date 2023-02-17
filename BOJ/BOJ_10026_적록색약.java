import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {
	static int N;
	static char[][] matrix;
	static boolean[][] visited;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 크기
		matrix = new char[N][N];
		visited = new boolean[N][N];
		for (int n = 0; n < N; n++) {
			matrix[n] = br.readLine().toCharArray();
		}

		int[] cnt = new int[2]; // 구역 수 저장할 배열
		for (int i = 0; i < N; i++) { // 적록색약 아닌 사람
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
//					bfs(i, j);
					dfs(i, j);
					cnt[0]++;
				}
				if (matrix[i][j] == 'G') { // 적록색약 아닌사람할때 미리 G를 R로 바꾸기
					matrix[i][j] = 'R';
				}
			}
		}
		visited = new boolean[N][N]; // 적록색약인 사람 구하기 위해서
		for (int i = 0; i < N; i++) { // 적록색약인 사람
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
//					bfs(i, j);
					dfs(i, j);
					cnt[1]++;
				}
			}
		}

		System.out.println(cnt[0] + " " + cnt[1]);

	}

	public static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { i, j });
		visited[i][j] = true; // 방문처리

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nexti = now[0] + di[d];
				int nextj = now[1] + dj[d];
				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && !visited[nexti][nextj]
						&& matrix[now[0]][now[1]] == matrix[nexti][nextj]) {
					queue.offer(new int[] { nexti, nextj });
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
			if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && !visited[nexti][nextj]
					&& matrix[i][j] == matrix[nexti][nextj]) {
				dfs(nexti, nextj);
			}
		}

	}

}
