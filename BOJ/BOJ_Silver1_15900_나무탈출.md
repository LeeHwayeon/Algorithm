# 나무 탈출

날짜: 2023년 2월 13일
레벨: Silver1
분류: 트리
언어: Java
출제기관: 백준

## 문제

[15900번: 나무 탈출](https://www.acmicpc.net/problem/15900)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_Silver1_15900_나무탈출 {
	static ArrayList[] tree;
	static boolean[] visited;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		tree = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		StringTokenizer st = null;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}

		dfs(1, 0);
		System.out.println(ans % 2 == 0 ? "No" : "Yes");
	}

	static void dfs(int num, int depth) {
		visited[num] = true;
		if (tree[num].size() == 1 && num != 1) { // 사이즈가 1이고 현재 num이 루트노드가 아니면 리프노드임
			ans += depth; //지금까지 깊이 더해주기
			return;
		}

		for (int i = 0; i < tree[num].size(); i++) {
			int now = (int) tree[num].get(i);
			if (!visited[now]) {
				dfs(now, depth + 1);
			}
		}
	}
}
```

- 1번 정점은 무조건 루트 노드고, 1번 정점을 제외한 정점 중 자식이 없는 경우 = 사이즈가 1인 경우는 리프 노드에 해당한다
- 리프 노드의 게임말을 루트 노드로 옮겨야 하니까 리프 노드와 루트 노드의 깊이를 구해주면 됨
- dfs이용해서 루트 노드인 1번 정점부터 시작해서 리프 노드를 만났을때 깊이를 더해준 후 총 깊이의 합이 짝수인 경우 형석이가 이기고 홀수인 경우 성원이가 이김