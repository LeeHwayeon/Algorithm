import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {
	static int N;
	static char map[][];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 영상크기
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		zip(0, 0, N);
		System.out.println(sb.toString());
	}

	public static boolean check(int i, int j, int N) {
		for (int x = i; x < i + N; x++) {
			for (int y = j; y < j + N; y++) {
				if (map[x][y] != map[i][j])
					return false;
			}
		}
		return true;
	}

	public static void zip(int i, int j, int N) {
		if (check(i, j, N)) { // 섞여 있지 않을때
			sb.append(map[i][j]);
			return;
		}

		// 0이랑 1이 섞여 있을 때
		sb.append("(");
		int size = N / 2;
		zip(i, j, size);
		zip(i, j + size, size);
		zip(i + size, j, size);
		zip(i + size, j + size, size);
		sb.append(")");
	}

}
