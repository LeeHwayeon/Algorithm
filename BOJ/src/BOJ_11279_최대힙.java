import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_11279_최대힙 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());

		int N = sc.nextInt(); // 연산 개수
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num == 0) {
				// 비어있는 데 큰 값 출력할 경우 0, 아닐 경우 가장 큰 값
				System.out.println(queue.isEmpty() ? 0 : queue.poll());
			} else {
				queue.offer(num);
			}
		}
	}

}
