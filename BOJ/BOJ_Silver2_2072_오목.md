# 오목

날짜: 2023년 3월 1일
레벨: Silver2
분류: 구현
언어: Java
출제기관: 백준

## 문제

[2072번: 오목](https://www.acmicpc.net/problem/2072)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Silver2_2072_오목 {
	static int[][] map;
	static int[] di = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[] dj = { 1, 1, 1, 0, -1, -1, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[20][20];
		int N = Integer.parseInt(br.readLine()); // 돌의 개수

		StringTokenizer st = null;
		// 홀수 : 1, 짝수 : 2
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int ii = Integer.parseInt(st.nextToken());
			int jj = Integer.parseInt(st.nextToken());
			map[ii][jj] = i % 2 == 0 ? 2 : 1;

			if (playOmok(ii, jj, map[ii][jj])) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1); // 승패 갈리지 않는 경우

	}

	static boolean playOmok(int i, int j, int color) {
		for (int d = 0; d < 4; d++) {
			int nexti = i;
			int nextj = j;
			int cnt = 1;

			while (true) {
				nexti += di[d];
				nextj += dj[d];
				if (check(nexti, nextj, color)) {
					cnt++;
				} else {
					break;
				}
			}

			nexti = i;
			nextj = j;
			// 반대방향
			while (true) {
				nexti += di[d + 4];
				nextj += dj[d + 4];
				if (check(nexti, nextj, color)) {
					cnt++;
				} else {
					break;
				}
			}

			if (cnt == 5) {
				return true;
			}
		}

		return false;
	}

	static boolean check(int i, int j, int color) {
		if (i >= 1 && i < 20 && j >= 1 && j < 20 && map[i][j] == color) {
			return true;
		}
		return false;
	}

}
```

- 입력받을때마다 방향별로 오목이 끝나는지 확인해주면 됨