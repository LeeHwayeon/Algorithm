import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {
	static int N, map[][];
	static boolean visited[][];
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static ArrayList<Integer> danji;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		danji = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s.charAt(j) + "");
			}
		}

		int danji_num = 10;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					bfs(i, j, danji_num);
					danji_num++;
				}
			}
		}

		Collections.sort(danji);
		System.out.println(danji.size());
		for (int i = 0; i < danji.size(); i++) {
			System.out.println(danji.get(i));
		}
	}

	public static void bfs(int i, int j, int danji_num) {
		int count = 1;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { i, j });
		map[i][j] = danji_num;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] now = queue.poll();

				for (int d = 0; d < 4; d++) {
					int nexti = now[0] + di[d];
					int nextj = now[1] + dj[d];

					if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && map[nexti][nextj] == 1) {
						map[nexti][nextj] = danji_num;
						queue.add(new int[] { nexti, nextj });
						count++;
					}
				}
			}
		}
		danji.add(count);
	}

}
