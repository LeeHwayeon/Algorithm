import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 카드 갯수
		int M = Integer.parseInt(st.nextToken()); // 카드 합

		int[] numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int min = Integer.MAX_VALUE;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					int sum = numbers[i] + numbers[j] + numbers[k];

					if (sum <= M) {
						int tmp = Math.abs(sum - M);
						if (tmp < min) {
							min = tmp;
							ans = sum;
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}
