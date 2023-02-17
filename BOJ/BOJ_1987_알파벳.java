import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int R, C, ans;
	static char[][] board;
	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer line = new StringTokenizer(br.readLine());

		R = Integer.parseInt(line.nextToken());
		C = Integer.parseInt(line.nextToken());
		board = new char[R][];

		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		visited = new boolean[26]; // 'A'->0, 'B'->1 ... 'Z'->25
		move(0, 0, 0);
		System.out.println(ans);

	}

	public static void move(int nowi, int nowj, int count) {
		ans = Math.max(ans, count + 1); // 현재칸 알파벳 밟은거니까 +1
		if (ans == 26)
			return;

		visited[board[nowi][nowj] - 'A'] = true; // 지금 칸에 적혀있는 알파벳 저장

		for (int d = 0; d < 4; d++) {
			int nexti = nowi + di[d];
			int nextj = nowj + dj[d];

			if (nexti >= 0 && nexti < R && nextj >= 0 && nextj < C && !visited[board[nexti][nextj] - 'A']) { // 유효 칸이면서
				// 지금까지 지나온 모든 칸에 적혀있는 알파벳과 다를 때
				move(nexti, nextj, count + 1); // 그 다음 탐색..
			}
		}
		visited[board[nowi][nowj] - 'A'] = false; // 갈 수 없을때 다시 바꿔놓기
	}

}
