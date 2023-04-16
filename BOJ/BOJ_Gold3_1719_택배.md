# 택배

날짜: 2023년 4월 8일
레벨: Gold3
분류: 플로이드와샬
언어: Java
출제기관: 백준

## 문제

[1719번: 택배](https://www.acmicpc.net/problem/1719)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Gold3_1719_택배 {
	static int n, m, dist[][], map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 정점 수
		m = Integer.parseInt(st.nextToken()); // 경로 수
		dist = new int[n + 1][n + 1]; // 최소거리
		map = new int[n + 1][n + 1]; // 경로표

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = j; // i->j 경로이므로 j로 초기화
				dist[i][j] = 200 * 10000 + 1; // 정점 최대 개수 * 경로 개수 + 1
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			dist[a][b] = Math.min(dist[a][b], d);
			dist[b][a] = Math.min(dist[b][a], d);
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) { // 만약 k를 거쳐가는게 더 최소면
						dist[i][j] = dist[i][k] + dist[k][j];
						map[i][j] = map[i][k]; // k경로로 갱신
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					System.out.print("- ");
				else
					System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
```

- 모든 정점간의 경로를 구해야하기 때문에 플로이드와샬이용
- 최소값 갱신할때 경로도 같이 갱신해준다.