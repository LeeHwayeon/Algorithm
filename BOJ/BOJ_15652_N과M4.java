import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652_N과M4 {
	static int N, M, result[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];

		combi(0, 0);
	}

	public static void combi(int cnt, int idx) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + 1 + " ");
			}
			System.out.println();
			return;
		}

		for (int i = idx; i < N; i++) {
			result[cnt] = i;
			combi(cnt + 1, i);
		}

	}

}
