import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static int N, people[], min, map[][];
	static boolean[] isSelected;

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		isSelected = new boolean[N + 1];
		people = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // i번 지역과 인접한 지역 갯수
			for (int j = 1; j <= num; j++) {
				int num1 = Integer.parseInt(st.nextToken());
				map[i][num1] = 1;
				map[num1][i] = 1;
			}
		}

		min = Integer.MAX_VALUE;

		subset(1); // 지역번호는 1번부터 시작

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	public static int bfs(int start, int cnt) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];
		queue.offer(start);
		visited[start] = true;

		int connect = 0; // 연결되어 있는 정점 수
		int sum = 0; // 큐에 들어가는 인구 합
		while (!queue.isEmpty()) {
			int now = queue.poll();
			connect++;
			sum += people[now];

			for (int i = 1; i <= N; i++) {
				// 정점이 연결되어 있고 방문하지 않았고, 현재 정점의 부분집합상태와 다음 정점의 부분집합상태가 동일할때만
				if (map[now][i] == 1 && !visited[i] && isSelected[now] == isSelected[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}

		return connect == cnt ? sum : -1; // 연결된 정점의 개수가 다르면 -1

	}

	public static void subset(int cnt) {
		if (cnt == N + 1) {
			int startA = 0, startB = 0;
			int cntA = 0, cntB = 0;
			for (int i = 1; i <= N; i++) {
				if (isSelected[i]) {
					startA = i;
					cntA++;
				} else {
					startB = i;
					cntB++;
				}
			}
			cntA = bfs(startA, cntA); // 선택된 정점
			cntB = bfs(startB, cntB); // 비선택된 정점

			if (cntB > 0 && cntA > 0) { // 선거구를 두개로 나눌 수 있을 떄만
				min = Math.min(min, Math.abs(cntA - cntB));
			}

			return;
		}

		isSelected[cnt] = true;
		subset(cnt + 1);

		isSelected[cnt] = false;
		subset(cnt + 1);
	}

}
