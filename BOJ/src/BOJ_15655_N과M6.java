import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15655_N과M6 {
	static int N, M, array[];
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		array = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);

		dfs(0, 0);
	}

	public static void dfs(int cnt, int idx) {
		if (cnt == M) {
			for (int i = 0; i < N; i++) {
				if (visited[i])
					System.out.print(array[i] + " ");
			}
			System.out.println();
			return;
		}

		if (idx == N) {
			return;
		}

		visited[idx] = true;
		dfs(cnt + 1, idx + 1);
		visited[idx] = false;
		dfs(cnt, idx + 1);

	}

}
