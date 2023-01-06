# 2573_빙산

날짜: 2023년 1월 6일
레벨: Gold
분류: BFS/DFS
상세레벨: Gold4

[2573번: 빙산](https://www.acmicpc.net/problem/2573)

### 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int N, M, map[][], time = 0, count = 0;;

	static class Point {
		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 영역이 2보다 작을때까지 반복
		while ((count = countArea()) < 2) {
			if (count == 0) { // 영역이 0 = 분리되지 않음
				time = 0;
				break;
			}

			melting();
			time++;

		}

		System.out.println(time);
	}

	// 빙산 녹이기
	static void melting() {
		boolean[][] visited = new boolean[N][M];
		Queue<Point> queue = new LinkedList<>();
		// 빙산 높이 0 이상인 곳 queue에
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					queue.offer(new Point(i, j));
					visited[i][j] = true;
				}
			}
		}
		while (!queue.isEmpty()) {
			Point now = queue.poll();

			int count = 0;
			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M) {
					if (!visited[nexti][nextj] && map[nexti][nextj] == 0) {
						count++;
					}
				}
			}
			map[now.i][now.j] = map[now.i][now.j] - count < 0 ? 0 : map[now.i][now.j] - count;
		}
	}

	// 영역 세기
	static int countArea() {
		boolean[][] area = new boolean[N][M];
		int num = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !area[i][j]) {
					bfs(i, j, area);
					num++;
				}
			}
		}
		return num;
	}

	static void bfs(int i, int j, boolean[][] area) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(i, j));
		area[i][j] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				// 유효 범위이면서 map[next.i][next.j]의 높이가 0이 아니고
				// area[next.i][next.j]가 방문아직 안한것
				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && map[nexti][nextj] != 0
						&& !area[nexti][nextj]) {
					area[nexti][nextj] = true;
					queue.offer(new Point(nexti, nextj));
				}
			}
		}
	}
}
```

- 빙산 영역이 2 영역 이상으로 나눠지면 반복문 종료
    1. 영역 개수 세기
        1. *`map*[i][j] != 0 && !area[i][j]` 조건 만족하는 경우 `bfs`
        2. 만약 return한 영역 개수가 2보다 작으면 반복문 종료 후 그때의 time 값 출력
        3. 영역 개수 0인 경우 이미 다 녹은 것
    2. 빙산 녹이기
        1. 빙산 높이 0 이상인 경우만 `queue`에 저장 후 `bfs`
        2. 이미 녹아서 0이 된 경우 다음 빙산에 영향 끼칠 수 있으니 `visited`로 방문 체크