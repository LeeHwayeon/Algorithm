import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819_차이를최대로 {
	static int N, numbers[], result[], max;
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		numbers = new int[N];
		result = new int[N];
		visited = new boolean[N];
		max = 0;
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);
		System.out.println(max);
	}

	public static void dfs(int cnt, int sum) {
		if (cnt >= N && sum > max) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				result[cnt] = numbers[i];
				visited[i] = true;
				if (cnt != 0) {
					dfs(cnt + 1, sum + Math.abs(result[cnt - 1] - result[cnt]));
				} else {
					dfs(cnt + 1, sum);
				}
				visited[i] = false;
			}
		}
	}

}
