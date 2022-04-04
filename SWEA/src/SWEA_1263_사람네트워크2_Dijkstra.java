import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1263_사람네트워크2_Dijkstra {
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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			List<Point>[] list = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<Point>();
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int input = Integer.parseInt(st.nextToken());
					if (input == 1) {
						list[i].add(new Point(j, 1));
						list[j].add(new Point(i, 1));
					}
				}
			}

			int min = 987654321;
			// 모든 정점을 계산해봐야 하기 때문에 N번 반복
			for (int i = 1; i <= N; i++) {
				boolean[] visited = new boolean[N + 1];
				int[] distance = new int[N + 1];
				Arrays.fill(distance, 987654321);

				distance[i] = 0;

				PriorityQueue<Point> pq = new PriorityQueue<Point>();
				pq.offer(new Point(i, distance[i]));

				while (!pq.isEmpty()) {
					Point now = pq.poll();

					if (visited[now.end])
						continue;
					visited[now.end] = true;

					for (Point p : list[now.end]) {
						if (distance[p.end] > distance[now.end] + p.weight) {
							distance[p.end] = distance[now.end] + p.weight;
							pq.offer(new Point(p.end, distance[p.end]));
						}
					}
				}

				int sum = 0;
				for (int j = 1; j <= N; j++) { // 각 거리 합하기
					sum += distance[j];
				}

				for (int j = 1; j <= N; j++) { // 각 정점에서 거리의 합 비교
					min = Math.min(min, sum);
				}
			}
			System.out.println("#" + tc + " " + min);

		}
	}

}
