# 오목

날짜: 2023년 3월 1일
레벨: Silver1
분류: 구현
언어: Java
출제기관: 백준

## 문제

[2615번: 오목](https://www.acmicpc.net/problem/2615)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Silver1_2615_오목 {
	static int[][] map;
	static int[] di = { -1, 0, 1, 1 }; // 가로, 세로, 대각선
	static int[] dj = { 1, 1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[19][19];

		for (int i = 0; i < 19; i++) { // 입력
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 가장 왼쪽에 있는 바둑알의 번호를 출력하기 위해 증가를 j -> i 로 설정
		for (int j = 0; j < 19; j++) {
			for (int i = 0; i < 19; i++) {
				if (map[i][j] != 0) {
					if (playOmok(i, j)) {
						System.out.println(map[i][j]);
						System.out.println((i + 1) + " " + (j + 1));
						return;
					}
				}
			}
		}
		System.out.println(0); // 승부 결정 전
	}

	// 연속된 바둑알 검사하기
	static boolean playOmok(int i, int j) {
		for (int d = 0; d < 4; d++) {
			int nowi = i;
			int nowj = j;
			int cnt = 1; // 자기자신 포함하기 때문에 1로 세팅

			while (true) {
				int nexti = nowi + di[d];
				int nextj = nowj + dj[d];

				if (check(nexti, nextj, map[i][j])) {
					nowi = nexti;
					nowj = nextj;
					cnt++;
				} else {
					break;
				}
			}

			// 반대방향 탐색
			nowi = i;
			nowj = j;

			while (true) {
				int nexti = nowi - di[d];
				int nextj = nowj - dj[d];

				if (check(nexti, nextj, map[i][j])) {
					nowi = nexti;
					nowj = nextj;
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

	static boolean check(int nexti, int nextj, int color) {
		if (nexti < 0 || nexti >= 19 || nextj < 0 || nextj >= 19 || map[nexti][nextj] != color)
			return false;
		return true;
	}
}
```

- 처음에 bfs이용해서 풀었는데 현재 방향의 반대방향 탐색이 까다로워서 실패
- 현재 방향 + 반대 방향을 모두 탐색한 뒤에 카운트가 5라면 오목 게임 끝
- 가장 왼쪽에 있는 바둑알 번호가 출력되도록 이중 for문에서 증가하는 것을 `i→j`가 아닌 `j→i`로 설정해줘야 함