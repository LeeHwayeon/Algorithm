import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1263_사람네트워크2_Floyd {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int[][] map = new int[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && map[i][j] == 0) {
						map[i][j] = 9999999;
					}
				}
			}

			// 경유지-->출발지-->목적지로 3중 루프 돌려야 정답
			for (int k = 1; k <= N; ++k) {
				for (int i = 1; i <= N; ++i) {
					if (i == k)
						continue; // 출발지와 경유지가 같다면 다음 출발지
					for (int j = 1; j <= N; ++j) {
						if (i == j || k == j)
							continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
						if (map[i][j] > map[i][k] + map[k][j]) {
							map[i][j] = map[i][k] + map[k][j];
						}
					}
				}
			}
			int min = 9999999;
			for(int i=1; i<=N; i++) {
				int sum = 0;
				for(int j=1; j<=N; j++) {
					sum += map[i][j];
				}
				min = Math.min(sum, min);
			}

			System.out.println("#" + tc + " " + min);

		}
	}

}