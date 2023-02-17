import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 색종이 수
		int[][] dohwaji = new int[100][100]; // 100x100 도화지

		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int i = x; i < x + 10; i++) { // 색종이 크기가 10x10이므로 +10
				for (int j = y; j < y + 10; j++) {
					dohwaji[i][j] = 1;
				}
			}
		}
		int count = 0;

		for (int[] num : dohwaji) {
			for (int n : num) {
				if (n == 1) {
					count++;
				}
			}
		}

		System.out.println(count);
	}

}
