import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토2 {
	static int M, N, tomato[][], day;
	static int[] di = { -1, 1, 0, 0 }; // 상,하,좌,우
	static int[] dj = { 0, 0, -1, 1 };
	static Queue<Point> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 가로=열
		N = Integer.parseInt(st.nextToken()); // 세로=행
		tomato = new int[N][M];

		queue = new LinkedList<Point>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1) { // 익은 토마토일때 주변 탐색하기 위해 큐에 넣기 : 익은 토마토가 여러군데 있기 때문에 큐 사용
					queue.offer(new Point(i, j));
				}
			}
		}
		
		day = 0;
		while (!queue.isEmpty()) {
			int size = queue.size(); // 현재 익은 토마토
			for (int s = 0; s < size; s++) { // 동시에 익는 애들 찾기
				Point current = queue.poll();

				for (int d = 0; d < 4; d++) {
					int nexti = current.x + di[d];
					int nextj = current.y + dj[d];

					if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && tomato[nexti][nextj] == 0) {
						tomato[nexti][nextj] = 1; // 현재 일수 + 1
						queue.offer(new Point(nexti, nextj));
					}
				}
			}
			if (queue.size() > 0) {
				day++;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0) { // 탐색 끝나고도 익지않은 토마토가 있다면 -1
					day = -1;
				}
			}
		}
		System.out.println(day);

	}

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
