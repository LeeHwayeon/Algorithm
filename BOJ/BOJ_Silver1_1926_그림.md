# 그림

날짜: 2023년 2월 16일
레벨: Silver1
분류: BFS/DFS
언어: Java
출제기관: 백준

## 문제

[1926번: 그림](https://www.acmicpc.net/problem/1926)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Silver1_1926_그림 {
	static int n, m, map[][], max;
	static boolean visited[][];
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 열
		map = new int[n][m];
		visited = new boolean[n][m];
		max = 0;

		for (int i = 0; i < n; i++) { // 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}

	static void bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(i, j));
		visited[i][j] = true;

		int sum = 1;
		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				if (nexti >= 0 && nexti < n && nextj >= 0 && nextj < m && !visited[nexti][nextj]
						&& map[nexti][nextj] == 1) {
					queue.add(new Point(nexti, nextj));
					visited[nexti][nextj] = true;
					sum++;
				}
			}
		}
		max = Math.max(max, sum);
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}
```

- 색칠이 된 부분(1)이며 아직 방문하지 않았을 경우에만 bfs 시작
    - 그림 개수(cnt) 증가
    - 그림의 넓이를 구하기 위한 sum
    - 조건에 맞는 경우에만 queue에 넣고 sum을 증가
    - max와 sum중 최댓값 갱신