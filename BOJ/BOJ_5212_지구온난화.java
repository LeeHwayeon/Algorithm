import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5212_지구온난화 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		char[][] newMap = new char[R][C];

		int di[] = { -1, 1, 0, 0 };
		int dj[] = { 0, 0, -1, 1 };

		int minR = 10, minC = 10;
		int maxR = 0, maxC = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'X') {
					int cnt = 0; // 바다 수
					for (int d = 0; d < 4; d++) {
						int nexti = i + di[d];
						int nextj = j + dj[d];

						if ((nexti == -1 || nextj == -1 || nexti == R || nextj == C) || map[nexti][nextj] == '.') {
							cnt++;
						}
					}

					if (cnt >= 3) {
						newMap[i][j] = '.';
					} else {
						newMap[i][j] = 'X';
						minR = Math.min(minR, i);
						minC = Math.min(minC, j);
						maxR = Math.max(maxR, i);
						maxC = Math.max(maxC, j);
					}
				} else {
					newMap[i][j] = '.';
				}
			}
		}

		for (int i = minR; i <= maxR; i++) {
			for (int j = minC; j <= maxC; j++) {
				System.out.print(newMap[i][j]);
			}
			System.out.println();
		}

	}
}
