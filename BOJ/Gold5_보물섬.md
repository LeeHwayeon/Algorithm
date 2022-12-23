# 보물섬

날짜: 2022년 12월 23일
레벨: Gold
분류: BFS, 완전탐색
상세레벨: Gold5

[2589번: 보물섬](https://www.acmicpc.net/problem/2589)

### 내 풀이

```jsx
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {
	static int[] di = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dj = { 0, 0, -1, 1 };
	static int N, M, max;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') { // 육지인거 모두 탐색
					bfs(i, j);
				}
			}
		}
		System.out.println(max);
	}

	public static void bfs(int i, int j) {
		boolean[][] visited = new boolean[N][M];
		visited[i][j] = true;

		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(i, j, 0));

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M || visited[nexti][nextj]
						|| map[nexti][nextj] == 'W') {
					continue;
				}
				visited[nexti][nextj] = true;
				queue.offer(new Point(nexti, nextj, now.cnt + 1));
				max = Math.max(max, now.cnt + 1);
			}
		}
	}

	static class Point {
		int i;
		int j;
		int cnt;

		public Point(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}

}
```

- 육지인 영역을 모두 탐색해서 이동 시간 먼 곳 찾으면 되는 완탐 문제