import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6118_숨바꼭질 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 헛간 개수
		int M = Integer.parseInt(st.nextToken()); // 헛간 길

		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}

		boolean[] visited = new boolean[N + 1];
		int[] distance = new int[N + 1];

		Queue<Integer> pq = new LinkedList();
		pq.offer(1);
		visited[1] = true;

		while (!pq.isEmpty()) {
			int now = pq.poll();

			for (Integer i : list[now]) {
				if (!visited[i]) {
					distance[i] = distance[now] + 1;
					visited[i] = true;
					pq.offer(i);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		int maxIndex = 0;
		int count = 0; // 최댓값이랑 같은게 몇개인지
		for (int i = 1; i <= N; i++) {
			if (max < distance[i]) {
				max = distance[i];
				maxIndex = i;
				count = 1;
			} else if (max == distance[i]) {
				count++;
			}
		}
		System.out.println(maxIndex + " " + max + " " + count);
	}

}
