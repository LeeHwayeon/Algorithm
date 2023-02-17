import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	static class Point implements Comparable<Point> {
		int end, weight;

		public Point(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			return this.weight - o.weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수

		LinkedList<Point>[] list = new LinkedList[V];
		int start = Integer.parseInt(br.readLine()) - 1; // 시작 정점의 번호 : 1빼는이유 정점번호가 1부터 시작해서(여기선 0부터 할거라서)

		for (int i = 0; i < V; i++) {
			list[i] = new LinkedList<Point>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Point(to, weight));
		}

		boolean[] visited = new boolean[V]; // 방문 확인
		int[] distance = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0; // 시작정점 비용을 0으로 세팅

		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.offer(new Point(start, 0));

		while (!pq.isEmpty()) {
			Point current = pq.poll();

			if (visited[current.end])
				continue;
			visited[current.end] = true;

			for (Point p : list[current.end]) {
				if (distance[p.end] > distance[current.end] + p.weight) {
					distance[p.end] = distance[current.end] + p.weight;
					pq.offer(new Point(p.end, distance[p.end]));
				}
			}
		}

		for (int i = 0; i < V; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(distance[i]);
			}
		}

	}

}
