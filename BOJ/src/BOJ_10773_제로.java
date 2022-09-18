import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) {
				stack.add(num);
			} else {
				stack.pop();
			}
		}

		int result = 0;
		for (Integer n : stack) {
			result += n;
		}
		System.out.println(result);
	}
}
