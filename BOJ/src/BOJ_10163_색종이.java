import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10163_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 색종이 수
		int[][] matrix = new int[1001][1001]; // 가로,세로 최대 1001칸

		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 왼쪽 아래 x 좌표
			int y = Integer.parseInt(st.nextToken()); // 왼쪽 아래 y 좌표
			int w = Integer.parseInt(st.nextToken()); // 너비
			int h = Integer.parseInt(st.nextToken()); // 높이

			for (int i = x; i < (x + w); i++) { // 색종이 면적에 맞게 채우기
				for (int j = y; j < (y + h); j++) {
					matrix[i][j] = n;
				}
			}
		}
		int[] count = new int[N + 1];
		int idx = 1;
		while (true) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][j] == idx) {
						count[idx]++;
					}
				}
			}
			idx++;
			if (idx > N) {
				break;
			}
		}

		for (int i = 1; i < N + 1; i++) {
			if (count[i] == 0)
				System.out.println(0);
			else
				System.out.println(count[i]);
		}
	}

}
