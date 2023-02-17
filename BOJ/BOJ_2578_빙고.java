import java.util.Scanner;

public class BOJ_2578_빙고 {
	static int[][] bingo = new int[5][5];
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = sc.nextInt();
			}
		}

		ans = 0;
		for (int n = 1; n <= 25; n++) {
			int num = sc.nextInt();

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (bingo[i][j] == num) {
						bingo[i][j] = 0;
					}
				}
			}

			check();
			if (ans >= 3) {
				System.out.println(n);
				break;
			}
			ans = 0;

		}

	}

	static void check() {
		int count = 0;
		for (int i = 0; i < 5; i++) {
			if (bingo[i][i] == 0) {
				count++;
			}
		}
		if (count == 5) {
			ans++;
		}

		count = 0;
		for (int i = 4; i >= 0; i--) {
			if (bingo[4 - i][i] == 0) {
				count++;
			}
		}
		if (count == 5) {
			ans++;
		}

		for (int i = 0; i < 5; i++) {
			count = 0;
			for (int j = 0; j < 5; j++) {
				if (bingo[j][i] == 0) {
					count++;
				}
			}
			if (count == 5) {
				ans++;
			}
		}

		for (int i = 0; i < 5; i++) {
			count = 0;
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == 0) {
					count++;
				}
			}
			if (count == 5) {
				ans++;
			}
		}
	}

}
