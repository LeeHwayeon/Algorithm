import java.util.Scanner;

public class BOJ_16926_배열돌리기 {
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 행 수
		int M = sc.nextInt(); // 열 수
		int R = sc.nextInt(); // 회전 수
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

//		print();

		// 하->우->상->좌
		int[] di = { 1, 0, -1, 0 };
		int[] dj = { 0, 1, 0, -1 };

		int rotateNum = Math.min(N, M) / 2; // 회전 시켜야 하는 구역 수
		for (int r = 0; r < R; r++) { // 회전 수만큼 반복
			for (int k = 0; k < rotateNum; k++) { // 회전 구역 수만큼 반복
				int nowi = k;
				int nowj = k;

				int idx = 0; // 방향 바꿀 인덱스
				int temp = map[nowi][nowj];
				while (idx < 4) {
					int nexti = nowi + di[idx];
					int nextj = nowj + dj[idx];
					if (nexti >= k && nextj >= k && nexti < N - k && nextj < M - k) {
						int nextTemp = map[nexti][nextj]; // 이동할 자리에 있는 것을 미리 저장
						map[nexti][nextj] = temp; // 현재 값을 이동 자리 값으로 넣어준
						nowi = nexti; // 다음에 이동시작할 위치를 갱신하고
						nowj = nextj;
						temp = nextTemp; // 이동할 자리에 있던 값을 그 다음 현재값으로 옮겨줌
					} else {
						idx++; // 방향 바꾸기
					}
				}
			}
		}
		print();

	}

	// 행렬 결과 출력 함수
	public static void print() {
		for (int[] nn : map) {
			for (int n : nn) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}

}
