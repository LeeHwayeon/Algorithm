import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10157_자리배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine());

		if (R * C < N) {
			System.out.println(0);
		} else if (N == 1) {
			System.out.println(1 + " " + 1);
		} else {
			int[][] matrix = new int[C][R];
			boolean[][] visited = new boolean[C][R];
			int[] di = { 0, 1, 0, -1 };
			int[] dj = { 1, 0, -1, 0 };

			int cnt = 1;
			int i = 0, j = 0;
			int resulti = 0, resultj = 0;
			matrix[i][j] = cnt;
			int d = 0;
			while (true) {
				visited[i][j] = true;
				int nexti = i + di[d];
				int nextj = j + dj[d];

				if (nexti < 0 || nexti >= C || nextj < 0 || nextj >= R || visited[nexti][nextj]) {
					d++;
					if (d > 3) {
						d %= 4;
					}
				}
				cnt++;
				matrix[nexti][nextj] = cnt;
				i = nexti;
				j = nextj;

				if (cnt == N) {
					resulti = i + 1;
					resultj = j + 1;
					break;
				}

				if (cnt == R * C) {
					break;
				}
			}
			System.out.println(resulti + " " + resultj);
		}
	}

}
