import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3190_뱀 {
	static int N, K, L, map[][], time;
	static StringTokenizer st;
	static int[] di = { -1, 0, 1, 0 }; // 상, 우, 하, 좌
	static int[] dj = { 0, 1, 0, -1 };
	static Point head, tail;
	static Map<Integer, Integer> direction;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine()); // 보드 크기
		K = stoi(br.readLine()); // 사과 개수
		map = new int[N + 1][N + 1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[stoi(st.nextToken())][stoi(st.nextToken())] = 9; // 사과
		}

		direction = new HashMap<Integer, Integer>(); // 방향 변환 정보 담을 큐
		L = stoi(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = stoi(st.nextToken());
			String d = st.nextToken();
			direction.put(time, d.equals("L") ? 1 : -1);
		}
		System.out.println(move(1, 1));
	}

	public static int move(int i, int j) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(i, j));
		map[i][j] = 1;
		int d = 1;
		int time = 0;
		Point now = new Point(1, 1);

		while (true) {
			int nexti = now.x + di[d]; // 다음칸에 위치
			int nextj = now.y + dj[d];
			time++;

			if (nexti < 1 || nexti > N || nextj < 1 || nextj > N || map[nexti][nextj] == 1) { // 벽이나 몸에 부딪힘
				break;
			}
			if (map[nexti][nextj] != 9) { // 사과 아니면 꼬리 칸 비우기
				map[queue.peek().x][queue.peek().y] = 0;
				queue.poll();
			}

			queue.offer(new Point(nexti, nextj));
			map[nexti][nextj] = 1;
			now.x = nexti;
			now.y = nextj;

			if (direction.containsKey(time)) { // 방향 바꾸기
				if (direction.get(time).equals(-1)) { // 오른쪽
					d = d + 1 > 3 ? 0 : d + 1;
				} else {
					d = d - 1 < 0 ? 3 : d - 1;
				}
			}
		}
		return time;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
