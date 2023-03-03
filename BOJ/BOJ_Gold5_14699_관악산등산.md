# 관악산 등산

날짜: 2023년 2월 24일
레벨: Gold5
분류: DP, 그래프
언어: Java
출제기관: 백준

## 문제

[14699번: 관악산 등산](https://www.acmicpc.net/problem/14699)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_Gold5_14699_관악산등산 {
	static int N, M, height[], ans[];
	static ArrayList<Integer>[] list;
	static PriorityQueue<Shelter> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		height = new int[N + 1];
		ans = new int[N + 1];
		list = new ArrayList[N + 1];
		queue = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			queue.add(new Shelter(height[i], i));
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (height[a] < height[b]) { // 작은 곳에서 높은 곳으로만 갈 수 있도록 단방향 연결
				list[a].add(b);
			} else {
				list[b].add(a);
			}
		}

		// 높은 곳에서 내려오면서 갈 수 있는 곳 탐색
		while (!queue.isEmpty()) {
			Shelter now = queue.poll();
			int cnt = 0;

			// 연결된 곳 탐색하면서 최댓값 갱신
			for (int next : list[now.index]) {
				cnt = Math.max(cnt, ans[next]);
			}
			ans[now.index] = cnt + 1;
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(ans[i]);
		}
	}

	static class Shelter implements Comparable<Shelter> {
		int height, index;

		public Shelter(int height, int index) {
			super();
			this.height = height;
			this.index = index;
		}

		@Override
		public int compareTo(Shelter o) {
			return o.height - this.height;
		}
	}

}
```

- 시간초과가 날 거라고 생각했으나 DP의 방법이 떠오르지 않아서..
- 일단 입력을 받을때 어차피 자신보다 낮은곳은 이동할 수 없으니 자신보다 높은 곳으로 이동가능한 경우만 단방향으로 list만들어줌
- 정점 하나씩 돌면서.. 갈수 있는 최대 쉼터 개수를 구했는데..
    - 나름 시간초과를 막아보고자 사이즈가 0이면 아무데도 못가니 1로 세팅
    - 탐색하면서 다음값이 이미 탐색이 완료된 경우라면 그 ans[next]값에 1더하고 탐색하지 않기..
    - 최종적으로 갈 수 있는 최대 쉼터 수로 ans[num] 갱신…
- 결론적으로 메모리 초과가 났다.. 후

---

- 최종 해결 방법
    - pq를 이용해서 높이가 높은 곳부터 순차적으로 탐색
    - 지금 인덱스에서 연결된 곳 모두 탐색하면서 최댓값을 찾는다
        - 연결이 되어 있다면 next가 갈 수 있는 정점의 개수에 내 자신(now)이 한 번 더 갈수 있으므로