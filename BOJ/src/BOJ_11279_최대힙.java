import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_11279_최대힙 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder()); // Comparable

//		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() { // Comparator -> 시간초과
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2 - o1;
////				return -o1.compareTo(o2);
//			}
//		});

		int N = sc.nextInt(); // 연산 개수
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num == 0) {
				if (queue.isEmpty()) { // 비어있는 데 큰 값 출력할 경우
					System.out.println(0);
				} else { // 비어 있지 않을때 가장 큰 값 출력
					System.out.println(queue.poll());
				}
			} else {
				queue.offer(num);
			}
		}
	}

}
