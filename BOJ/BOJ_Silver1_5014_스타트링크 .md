# 스타트링크

날짜: 2023년 1월 4일
레벨: Silver
분류: BFS/DFS
상세레벨: Silver1

[5014번: 스타트링크](https://www.acmicpc.net/problem/5014)

### 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014_스타트링크 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken()); // 총 F층
		int S = Integer.parseInt(st.nextToken()); // 현재 S층에 위치함
		int G = Integer.parseInt(st.nextToken()); // 스타트링크 있는 층
		int U = Integer.parseInt(st.nextToken()); // 위로 U층
		int D = Integer.parseInt(st.nextToken()); // 아래로 D층

		boolean[] visited = new boolean[F + 1];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { S, 0 });
		visited[S] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			if (now[0] == G) {
				System.out.println(now[1]);
				return;
			}
			if (now[0] + U <= F && !visited[now[0] + U]) {
				visited[now[0] + U] = true;
				queue.offer(new int[] { now[0] + U, now[1] + 1 });
			}
			if (now[0] - D >= 1 && !visited[now[0] - D]) {
				visited[now[0] - D] = true;
				queue.offer(new int[] { now[0] - D, now[1] + 1 });
			}
		}
		System.out.println("use the stairs");
	}

}
```

- BFS 이용해서 품
- 현재 층에서 +U, -D 한 층이 방문하지 않은 층이며, 범위안에 들어올때 queue에 offer