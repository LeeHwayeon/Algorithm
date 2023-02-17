import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_1로만들기_dfs {
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;

		dfs(N, 0);

		System.out.println(ans);
	}

	public static void dfs(int N, int cnt) {
		if (N == 1) {
			ans = Math.min(ans, cnt);
			return;
		}

		if (cnt >= ans)
			return;

		if (N % 3 == 0) {
			dfs(N / 3, cnt + 1);
		}
		if (N % 2 == 0) {
			dfs(N / 2, cnt + 1);
		}
		dfs(N - 1, cnt + 1);

	}

}