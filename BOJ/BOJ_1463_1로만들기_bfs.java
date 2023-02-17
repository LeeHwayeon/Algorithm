import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1463_1로만들기_bfs {
	public static class Node {
		int num, count;

		public Node(int num, int count) {
			super();
			this.num = num;
			this.count = count;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[N + 1];

		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(N, 0));

		int cnt = 0;
		while (!queue.isEmpty()) {
			Node now = queue.poll();

			if (now.num == 1) {
				System.out.println(now.count);
				break;
			}
			if (now.num > 1 && !visited[now.num]) {
				visited[now.num] = true;
				if (now.num % 3 == 0) {
					queue.offer(new Node(now.num / 3, now.count + 1));
				}
				if (now.num % 2 == 0) {
					queue.offer(new Node(now.num / 2, now.count + 1));
				}
				queue.offer(new Node(now.num - 1, now.count + 1));
			}
		}
	}

}