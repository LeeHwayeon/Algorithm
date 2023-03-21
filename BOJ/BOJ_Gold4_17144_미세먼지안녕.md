# 미세먼지 안녕!

날짜: 2023년 3월 21일
레벨: Gold4
분류: 구현
언어: Java
출제기관: 백준

## 문제

[17144번: 미세먼지 안녕!](https://www.acmicpc.net/problem/17144)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Gold4_17144_미세먼지안녕 {
	static int R, C, T, map[][], result[][];
	static Point[] air;
	static int di[] = { 0, -1, 0, 1 }; // 우, 상, 좌, 하
	static int dj[] = { 1, 0, -1, 0 };
	static Queue<Point> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken()); // 시간
		map = new int[R][C];
		result = new int[R][C];
		air = new Point[2]; // 공기청정기 위, 아래순
		int airIdx = 0;

		queue = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != -1) { // 미세먼지 위치
					queue.add(new Point(i, j));
				} else if (map[i][j] == -1) { // 공기청정기 위치
					result[i][j] = -1;
					air[airIdx++] = new Point(i, j);
				}
			}
		}

		while (T != 0) {
			spreadDust();
			spreadAir(di, dj, 0); // 공기청정기 위쪽 방향
			spreadAir(new int[] { 0, 1, 0, -1 }, new int[] { 1, 0, -1, 0 }, 1); // 아래쪽 방향
			copyMap();
			T--;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != -1 && map[i][j] != 0) {
						queue.add(new Point(i, j));
					}
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if ((i == air[0].i && j == air[0].j) || (i == air[1].i && j == air[1].j)) {
					continue;
				}
				ans += map[i][j];
			}
		}
		System.out.println(ans);
	}

	// result 배열 map 배열에 옮기기
	static void copyMap() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = result[i][j];
				result[i][j] = 0;
			}
		}
		map[air[0].i][air[0].j] = -1;
		map[air[1].i][air[1].j] = -1;
	}

	// 미세먼지 확산
	static void spreadDust() {

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			int amount = (int) Math.floor(map[now.i][now.j] / 5);

			// 확산할 수 있는 방향 몇개인지
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];
				if (!check(nexti, nextj) || map[nexti][nextj] == -1) {
					continue;
				}
				result[nexti][nextj] += amount;
				cnt++;
			}

			result[now.i][now.j] += map[now.i][now.j] - (amount * cnt);
		}
	}

	static void spreadAir(int[] di, int[] dj, int idx) {
		int d = 0;
		Point now = air[idx]; // 공기청정기 위치
		if (check(now.i + di[d], now.j + dj[d])) { // 다음칸 갈 수 있으면 다음칸이 현재임
			now = new Point(now.i + di[d], now.j + dj[d]);
		}

		int temp = 0;
		int nowValue = result[now.i][now.j];
		result[now.i][now.j] = 0;
		while (true) {
			if (now.i == air[idx].i && now.j == air[idx].j)
				break;

			if (!check(now.i + di[d], now.j + dj[d])) {
				d = (d + 1) % 4; // 방향 바꾸기
			}

			int nexti = now.i + di[d];
			int nextj = now.j + dj[d];

			temp = result[nexti][nextj]; // 다음칸의 값 저장
			result[nexti][nextj] = nowValue; // 다음칸에 현재 값 저장
			now = new Point(nexti, nextj); // 현재 위치를 다음 위치로 갱신
			nowValue = temp; // 현재 값에 다음칸 값 저장
		}
	}

	static boolean check(int x, int y) {
		if (x >= 0 && x < R && y >= 0 && y < C) {
			return true;
		}
		return false;
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

- 문제에서 제시한 조건대로 순서에 맞게 구현하면 되는 100% 구현 문제
1. 미세먼지 확산
    - 큐에 미세먼지가 있는 위치를 담아서 상,하,좌,우로 확산
2. 공기청정기 실행
    - 위쪽 방향, 아래쪽 방향 두가지로 나눠서 값 옮기는 spreadAir()수행
3. 배열 복사
    - result 배열에 1,2번 결과를 저장해줬기 때문에 다음 반복을 위해 map에 다시 복사하는 작업 수행