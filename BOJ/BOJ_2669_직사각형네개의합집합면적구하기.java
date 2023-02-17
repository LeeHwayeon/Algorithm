import java.util.Scanner;

public class BOJ_2669_직사각형네개의합집합면적구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] map = new int[101][101];

		for (int t = 0; t < 4; t++) {
			int xL = sc.nextInt(); // 왼쪽 아래 꼭짓점 좌표
			int yL = sc.nextInt();
			int xR = sc.nextInt(); // 오른쪽 위 꼭짓점 좌표
			int yR = sc.nextInt();

			for (int i = xL; i < xR; i++) {
				for (int j = yL; j < yR; j++) {
					map[i][j] = 1;
				}
			}
		}

		int count = 0; // 1 개수
		for (int[] nn : map) {
			for (int n : nn) {
				if (n == 1) {
					count++;
				}
			}
		}

		System.out.println(count);
	}

}
