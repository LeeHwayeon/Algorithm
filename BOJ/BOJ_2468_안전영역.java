import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {
	static int N, area[][], max, maxArea;
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		area = new int[N][N];
		max = 1;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, area[i][j]);
			}
		}

		maxArea = 1;
		for (int m = 1; m <= max; m++) {
			visited = new boolean[N][N];
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && area[i][j] > m) {
						count += dfs(i, j, m);
					}
				}
			}
			maxArea = Math.max(maxArea, count);
		}
		System.out.println(maxArea);
	}

	static int dfs(int i, int j, int height) {
		visited[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int nexti = i + di[d];
			int nextj = j + dj[d];

			if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && !visited[nexti][nextj]
					&& area[nexti][nextj] > height) {
				dfs(nexti, nextj, height);
			}
		}
		return 1;
	}

}
