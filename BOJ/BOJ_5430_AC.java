import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_5430_AC {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케
		sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			String p = br.readLine(); // 수행할 함수 p

			int n = Integer.parseInt(br.readLine()); // 배열 수

			ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
			String s = br.readLine().replaceAll("\\[", "").replaceAll("\\]", "");
			StringTokenizer st = new StringTokenizer(s, ",");
			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			System.out.println(print(deque, p));
		}
	}

	static String print(ArrayDeque<Integer> deque, String commands) {
		boolean reverse = false;

		for (char command : commands.toCharArray()) {
			if (command == 'R')
				reverse = !reverse; // 뒤집기
			else { // 버리기
				if (deque.size() == 0) // deque 크기가 0일때 버리려고 하면 에러
					return "error";

				if (reverse)
					deque.removeLast();
				else
					deque.removeFirst();
			}
		}

		StringBuilder sb = new StringBuilder("[");
		while (!deque.isEmpty()) {
			sb.append(reverse ? deque.removeLast() : deque.removeFirst());
			if (deque.size() != 0)
				sb.append(',');
		}
		sb.append(']');

		return sb.toString();
	}

}
