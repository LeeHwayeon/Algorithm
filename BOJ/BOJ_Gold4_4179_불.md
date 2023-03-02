# 불!

날짜: 2023년 3월 2일
레벨: Gold4
분류: BFS/DFS, 구현
언어: Java
출제기관: 백준

## 문제
[4179 - 불!](https://www.acmicpc.net/problem/4179)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Gold4_4179_불 {
	static int R, C, ans;
	static char[][] map;
	static boolean[][] visited;
	static Queue<Miro> queue;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		ans = -1; // 탈출할 수 없는 경우
		visited = new boolean[R][C];

		Miro start = null;
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'J') { // 초기 위치
					start = new Miro(i, j, 1);
					visited[i][j] = true;
				}
			}
		}

		queue = new LinkedList<>();
		// 지훈 -> 불 순서
		queue.add(start);
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'F') {
					queue.add(new Miro(i, j, 0));
				}
			}
		}
		bfs();
		System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			Miro now = queue.poll();
			char status = map[now.x][now.y];
			if (status == 'J') {
				if (escape(now.x, now.y)) { // 탈출할 수 있음
					ans = now.time;
					break;
				}

				// 지훈이일 경우에만 지훈이가 있던 자리 지나갈 수 있는 공간으로 갱신
				map[now.x][now.y] = '.';
			}
			for (int d = 0; d < 4; d++) {
				int nexti = now.x + di[d];
				int nextj = now.y + dj[d];
				if (check(nexti, nextj, status)) {
					// 불인경우 다음 좌표가 불이 아닌 경우만
					// 지훈이는 방문 안한 경우만 이동 가능
					if ((status == 'J' && !visited[nexti][nextj]) || (status == 'F' && map[nexti][nextj] != 'F')) {
						queue.add(new Miro(nexti, nextj, now.time + 1));
						map[nexti][nextj] = status;
						visited[nexti][nextj] = true;
					}
				}
			}
		}
	}

	// 지금 위치가 미로의 가장자리에 접한 공간인지
	static boolean escape(int i, int j) {
		if (i == 0 || j == 0 || i == R - 1 || j == C - 1) {
			return true;
		}
		return false;
	}

	// 유효한 인덱스인지
	static boolean check(int i, int j, char status) {
		boolean flag = true;
		if (i < 0 || i >= R || j < 0 || j >= C || map[i][j] == '#') {
			flag = false;
		}
		if (status == 'J' && map[i][j] == 'F') { // 지훈이는 불이 위치한 곳으로 갈 수 없음
			flag = false;
		}
		return flag;
	}

	static class Miro {
		int x, y, time;

		public Miro(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}
```

- 처음에는 방문처리를 안해줘서 메모리 초과 발생 ⇒ 어차피 다음 좌표 값을 현재 좌표 값으로 덮어쓰니까 안해줘도 될거라 생각했으나 그게 아니었다..
- 두번째는 불이 하나 이상 들어올 수 있다는 조건을 간과..!
    - J는 입력에서 하나만 주어진다 ⇒ 이 조건을 보고 불은 여러개가 들어올 수 있다는 것을 알아챘어야 했다
- 결론적으로 bfs 수행하면서 다음 좌표가 유효한 좌표일때
    - 지훈 : `status == 'J' && !*visited*[nexti][nextj]` 방문 안한 곳만 큐에 넣고
    - 불 : `status == 'F' && *map*[nexti][nextj] != 'F'` 다음 좌표의 값이 불이 아닐때만 큐에 넣어야 함
    - 그리고 지훈이인 경우에는 탈출할 수 있는지 없는지를 체크해줘서 탈출할 수 있음 그때 반복문 break
