import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
	static int N, M, map[][], max;
	static int di[] = { -1, 0, 1, 0 }; // 상, 우, 하, 좌
	static int dj[] = { 0, 1, 0, -1 };
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, 0, 0);
				exception(i, j);
			}
		}
		System.out.println(max);
	}

	static void dfs(int i, int j, int depth, int sum) {
		if (depth == 4) {
			max = Math.max(sum, max);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nexti = i + di[d];
			int nextj = j + dj[d];

			if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && !visited[nexti][nextj]) {
				visited[nexti][nextj] = true;
				dfs(nexti, nextj, depth + 1, sum + map[nexti][nextj]);
				visited[nexti][nextj] = false;
			}
		}
	}

	static void exception(int i, int j) {
		int wing = 4; // 상,하,좌,우 날개 수
		int min = Integer.MAX_VALUE;
		int sum = map[i][j];

		for (int d = 0; d < 4; d++) {
			int nexti = i + di[d];
			int nextj = j + dj[d];

			if (wing <= 2) { // 날개가 2개 이하면 ㅗ,ㅏ,ㅓ,ㅜ 모양이 아님
				return;
			}

			if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M) {
				min = Math.min(min, map[nexti][nextj]);
				sum += map[nexti][nextj];
			} else { // 날개가 맵 바깥에 있는 경우 빼주기
				wing--;
				continue;
			}
		}

		if (wing == 4) { // 날개가 3개여야 모양이 맞으니까 가장 작은거 없애기
			sum -= min;
		}

		max = Math.max(max, sum);
	}

}
