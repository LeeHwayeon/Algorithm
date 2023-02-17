import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_11315_오목판정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			char[][] omok = new char[N][N];
			for (int n = 0; n < N; n++) {
				omok[n] = br.readLine().toCharArray();
			}

			int[] di = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상,하,좌,우,우상,좌상,우하,좌하
			int[] dj = { 0, 0, -1, 1, 1, -1, 1, -1 };

			String result = "NO";
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int count = 0;
					if (omok[i][j] == 'o') {
						count++;
						for (int d = 0; d < 8; d++) {
							int nexti = i + di[d];
							int nextj = j + dj[d];
							if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N || omok[nexti][nextj] == '.') {
								continue;
							} else {
								count++;
								int ii = nexti;
								int jj = nextj;
								for (int k = 0; k < 4; k++) {
									int ni = ii + di[d];
									int nj = jj + dj[d];
									if (ni < 0 || ni >= N || nj < 0 || nj >= N || omok[ni][nj] == '.') {
										count -= (k + 1);
										break;
									} else {
										count++;
										ii = ni;
										jj = nj;
									}
									if (count >= 5) {
										result = "YES";
										break;
									}
								}
							}
						}
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

}
