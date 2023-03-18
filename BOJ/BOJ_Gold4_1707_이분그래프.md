# 이분그래프

날짜: 2023년 3월 18일
레벨: Gold4
분류: 트리
언어: Java
출제기관: 백준

## 문제

[1707번: 이분 그래프](https://www.acmicpc.net/problem/1707)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Gold4_1707_이분그래프 {
	static int V, E, colors[];
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			colors = new int[V + 1];

			list = new ArrayList[V + 1];
			for (int i = 1; i < list.length; i++) {
				list[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}

			for (int i = 1; i < list.length; i++) { // 완전연결 그래프가 아닐 수 있기 때문에 모든 정점 수행
				if (colors[i] == 0) {
					paintColor(i);
				}
			}
			if (checkColor()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	static boolean checkColor() {
		for (int i = 1; i < list.length; i++) {
			for (Integer next : list[i]) {
				if (colors[i] == colors[next]) { // 나랑 연결된 정점이 색깔이 같으면 이분 그래프 아님
					return false;
				}
			}
		}
		return true;
	}

	static void paintColor(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		colors[num] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (Integer next : list[now]) {
				if (colors[next] == 0) {
					colors[next] = colors[now] * -1; // 나랑 연결된 정점 나랑 반대로 칠하기
					queue.add(next);
				}
			}
		}
	}
}
```

- 이분 그래프는 모든 정점을 두가지 색으로 칠하면서, 나와 연결된 정점은 나랑 다른 색이어야 한다
- 따라서 모든 정점 돌면서 색이 칠해져 있지 않으면 색을 칠하는 paintColor를 수행해준다 ⇒ 완전 연결 그래프가 아닐 수 있기 때문에 모든 정점 수행
- 그리고 모든 정점 다시 반복하면서 나랑 연결된 정점과 나의 색이 다른지 같은지를 찾아주면 된다.