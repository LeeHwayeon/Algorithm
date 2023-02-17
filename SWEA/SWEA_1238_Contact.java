import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238_Contact {
	static int len, start, ans;
	static List<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken()); // 데이터 길이
			start = Integer.parseInt(st.nextToken()); // 시작점

			list = new LinkedList[101]; // 번호 1~100
			visited = new boolean[101];
			for (int i = 1; i <= 100; i++) {
				list[i] = new LinkedList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len / 2; i++) { // from,to가 하나의 쌍이니까 길이 2로 나눠줌
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to); // 유향
			}

			bfs(start);

			System.out.println("#" + t + " " + ans);
		}
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int size = queue.size(); // 같은 너비끼리 모인 큐 사이즈 저장

			int max = Integer.MIN_VALUE;
			for (int s = 0; s < size; s++) {
				int current = queue.poll();
				max = Math.max(max, current); // 같은 너비내에서 비교해서 최댓값 갱신
				for (int i = 0; i < list[current].size(); i++) {
					if (!visited[list[current].get(i)]) { // 이 과정을 하면서 같은 너비끼리 모일것
						queue.offer(list[current].get(i));
						visited[list[current].get(i)] = true;
					}
				}
			}
			ans = max;
		}
	}

}
