import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861_정사각형방 {
	static int N;
	static int[][] room;
	// 상, 하, 좌, 우
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 0;
			min = 0;

			// 모든 i,j값 돌기?
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					move(i, j, room[i][j], 1); // count 1로 시작
				}
			}

			System.out.println("#" + tc + " " + min + " " + max);
		}
	}

	static int max, start, min;

	public static void move(int nowi, int nowj, int start, int count) {
//		System.out.println("nowi:" + nowi + " nowj:" + nowj + " start:" + start + " count:" + count);

		// 상,하,좌,우 움직이면서 이동할 수 있는지 확인
		for (int d = 0; d < 4; d++) {
			int nexti = nowi + di[d];
			int nextj = nowj + dj[d];

			// 이동하는 방 존재 & 현재방보다 이동방이 1 더 클때
			if (nexti >= 0 && nextj >= 0 && nexti < N && nextj < N && room[nexti][nextj] == room[nowi][nowj] + 1) {
				move(nexti, nextj, start, count + 1); // 다음으로 이동해서 확인
			}
		}

		if (max < count) {
//			System.out.println("max:" + max + " min" + min);
			max = count;
			min = start;
		} else if (max == count) { // 이동 방의 개수가 최대인 방이 여러개일때
//			System.out.println("max:" + max + " min" + min);
			max = count;
			min = Math.min(min, start); // 시작값이랑 비교해서 더 작은 값
		}

	}

}