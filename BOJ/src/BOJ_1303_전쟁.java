import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303_전쟁 {
	static int N, M;
	static char matrix[][];
	static boolean visited[][];
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가로 크기 = 열
		M = Integer.parseInt(st.nextToken()); // 세로 크기 = 행

		matrix = new char[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			matrix[i] = br.readLine().toCharArray();
		}

		int sumW = 0, sumB = 0;
		cnt = 1; // dfs일때 사용하기 위해 여기서 선언
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 'W' && !visited[i][j]) {
//					bfs(i, j);
					dfs(i, j);
					sumW += cnt * cnt;
				} else if (matrix[i][j] == 'B' && !visited[i][j]) {
//					bfs(i, j);
					dfs(i, j);
					sumB += cnt * cnt;
				}
				cnt = 1; // dfs일때 끝나고 난 후 다시 초기화
			}
		}
		System.out.println(sumW + " " + sumB);
	}

	static int cnt;

	public static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { i, j });
		visited[i][j] = true;

		cnt = 1; // 몇 명이 뭉쳐있는지 셀 변수, 처음에 들어갈때 이미 true처리 되니까 1부터 시작
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nexti = now[0] + di[d];
				int nextj = now[1] + dj[d];
				if (nexti >= 0 && nexti < M && nextj >= 0 && nextj < N && !visited[nexti][nextj]
						&& matrix[now[0]][now[1]] == matrix[nexti][nextj]) { // 전꺼랑 다음꺼 색이 같을때만
					queue.offer(new int[] { nexti, nextj });
					visited[nexti][nextj] = true;
					cnt++; // 조건이 일치하면 개수 증가
				}
			}
		}
	}

	public static void dfs(int i, int j) {
		visited[i][j] = true;

		for (int d = 0; d < 4; d++) {
			int nexti = i + di[d];
			int nextj = j + dj[d];
			if (nexti >= 0 && nexti < M && nextj >= 0 && nextj < N && !visited[nexti][nextj]
					&& matrix[i][j] == matrix[nexti][nextj]) { // 전꺼랑 다음꺼 색이 같을때만
				dfs(nexti, nextj);
				cnt++; // 조건이 일치하면 개수 증가
			}
		}
	}

}
