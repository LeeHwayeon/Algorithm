# 소셜네트워킹어플리케이션

날짜: 2023년 2월 6일
레벨: Gold5
분류: 유니온파인드
언어: Java
출제기관: 백준

## 문제

[7511번: 소셜 네트워킹 어플리케이션](https://www.acmicpc.net/problem/7511)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Gold5_7511_소셜네트워킹어플리케이션 {
	static int parent[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine()); // 유저 수
			int k = Integer.parseInt(br.readLine()); // 친구 관계 수
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}

			StringTokenizer st = null;
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}

			int m = Integer.parseInt(br.readLine()); // 구해야하는 쌍
			sb.append("Scenario " + t + ":\n");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				sb.append(findParent(a) == findParent(b) ? 1 + "\n" : 0 + "\n");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static int findParent(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = findParent(parent[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findParent(a);
		int bRoot = findParent(b);
		if (aRoot == bRoot)
			return false;
		parent[bRoot] = aRoot;
		return true;
	}
}
```

- 처음에 ArrayList 배열 만들어서 각 정점마다 연결된 정점 add해준 후 구할 쌍 u를 시작정점, v를 끝정점으로 해서 bfs로 탐색하면서 갈 수 있는지를 체크해주는식으로 풀었으나 메모리 초과가 남..
- 유니온파인드를 이용해서 먼저 친구 관계를 입력받을때 union함수로 부모 정점을 구해 준 뒤 구할 쌍의 부모 정점이 같은지를 체크해주는식으로 풀어야 메모리 초과가 나지 않는다..!