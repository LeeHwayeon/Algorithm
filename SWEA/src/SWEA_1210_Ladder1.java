import java.util.Scanner;

public class SWEA_1210_Ladder1 {
	static int[][] ladder = new int[100][100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] di = { 0, 0, -1 }; // 좌,우,상
		int[] dj = { -1, 1, 0 };
		int nowi = -1;
		int nowj = -1;
		int nexti = -1;
		int nextj = -1;
		int result = 0; // 출발점 j의 값을 담을 변수

		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt(); // 테케 번호

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();

					if (ladder[i][j] == 2) { // 도착점의 위치를 찾는다
						nowi = i;
						nowj = j;
					}
				}
			}

//			for (int i = 0; i < 100; i++) {
//				for (int j = 0; j < 100; j++) {
//					System.out.print(ladder[i][j]);
//				}
//				System.out.println();
//			}

			while (true) {
				ladder[nowi][nowj] = 9; // 이동했다는 표시

				for (int d = 0; d < 3; d++) { // 좌,우,상 돌기
					nexti = nowi + di[d];
					nextj = nowj + dj[d];

					// 인덱스값이 유효하고 1일때
					if (nexti >= 0 && nexti < 100 && nextj >= 0 && nextj < 100 && ladder[nexti][nextj] == 1) {
						nowi = nexti;
						nowj = nextj;
						break;
					}
				}

				if (nowi == 0) { // 0번 행에 도착했을때가 출발점 찾은 것
					result = nowj;
					break;
				}

			}

			System.out.println("#" + tc + " " + result);

		}
	}

}
