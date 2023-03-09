# 경로 찾기

날짜: 2023년 3월 9일
레벨: Silver1
분류: 그래프, 플로이드와샬
언어: Java
출제기관: 백준

## 문제

[11403번: 경로 찾기](https://www.acmicpc.net/problem/11403)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Silver1_11403_경로찾기 {
	static int N, map[][], ans[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		ans = new int[N][N];

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][k] == 1 && map[k][j] == 1) {
						map[i][j] = 1;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
```

- 모든 정점 i에 대해서 j로 가는 경로가 있는지 구하는 문제
    
    ⇒ 모든 정점에서 모든 정점으로의 최단거리를 구하는 알고리즘인 플로이드 와샬을 이용
    
- `i`에서 `j`로 가는건 `i`에서 `k`로 `k`에서 `j`로 가는 것과 같음