import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2999_비밀이메일 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int R = 0, C = 0;

		for (int i = 1; i <= str.length(); i++) {
			if ((str.length() % i) == 0) { // 메시지길이를 i값으로 나눈게 0이라면 i가 약수
				if (i <= (str.length() / i)) { // R이 C보다 작거나 같을때만
					R = i;
					C = str.length() / i;
				}
			}
		}

		char[][] map = new char[R][C];
		int idx = 0; // 메시지 뽑을 인덱스

		// 메시지->행렬
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {
				map[i][j] = str.charAt(idx);
				idx++;
			}
		}

		// 행렬 -> 메시지
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
		}

	}

}
