import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2458_키순서 {
	static int N, M, count[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생 수 = 정점 수
		M = Integer.parseInt(st.nextToken()); // 학생 키 비교한 횟수

		ArrayList<Integer>[] minToMax = new ArrayList[N + 1]; // 자신보다 큰 정점 비교 리스트
		ArrayList<Integer>[] maxToMin = new ArrayList[N + 1]; // 자신보다 작은 정점 비교 리스트
		count = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			minToMax[i] = new ArrayList<Integer>();
			maxToMin[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			minToMax[from].add(to);
			maxToMin[to].add(from);
		}

		for (int i = 1; i <= N; i++) {
			bfs(i, minToMax);
			bfs(i, maxToMin);
		}

		int ans = 0; // 자신의 키가 몇 번째인지 알 수 있는 학생 수
		for (int i = 1; i <= N; i++) {
			if(count[i] == N-1) ans++;
		}
		System.out.println(ans);
	}

	public static void bfs(int num, ArrayList<Integer>[] list) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];
		queue.offer(num);
		visited[num] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (Integer i : list[now]) {
				if (!visited[i]) {
					queue.offer(i);
					visited[i] = true;
					count[i]++; // 자신보다 큰 or 작은 정점이면 해당 정점 카운트 증가
				}
			}
		}
	}
}