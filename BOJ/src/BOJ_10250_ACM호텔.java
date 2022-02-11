import java.util.Scanner;

public class BOJ_10250_ACM호텔 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int H = sc.nextInt(); // 층 수
			int W = sc.nextInt(); // 방 수
			int N = sc.nextInt(); // 몇 번째 손님인지

			int roomH = N % H;
			int roomW = N / H;

			if (roomH == 0) { // 나머지가 0일때는 입력받은 H 출력
				System.out.println((H * 100) + roomW);
			} else {
				System.out.println((roomH * 100) + (roomW + 1));
			}
		}
	}
}
