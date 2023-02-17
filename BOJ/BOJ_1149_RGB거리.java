import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 집의 수

		int[][] house = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N; i++) {
			house[i][0] += Math.min(house[i - 1][1], house[i - 1][2]);
			house[i][1] += Math.min(house[i - 1][0], house[i - 1][2]);
			house[i][2] += Math.min(house[i - 1][1], house[i - 1][0]);
		}
		System.out.println(Math.min(Math.min(house[N - 1][0], house[N - 1][1]), house[N - 1][2]));

	}

}
