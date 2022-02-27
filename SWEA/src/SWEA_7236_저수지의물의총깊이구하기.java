import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7236_저수지의물의총깊이구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[][] matrix = new String[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					matrix[i][j] = st.nextToken();
				}
			}

			int[] di = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상,하,좌,우,우상,좌상,우하,좌하
			int[] dj = { 0, 0, -1, 1, 1, -1, 1, -1 };

			int max = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (matrix[i][j].equals("W")) {
						int count = 0;
						for (int d = 0; d < 8; d++) {
							int nexti = i + di[d];
							int nextj = j + dj[d];

							if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N || matrix[nexti][nextj].equals("G"))
								continue;
							else
								count++;
						}
						if (count == 0) {
							count++;
						}
						max = Math.max(max, count);
					}

				}
			}
			System.out.println("#" + t + " " + max);
		}
	}

}
