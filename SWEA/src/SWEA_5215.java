import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5215 {
	static int TC, N, L;
	static StringTokenizer line;
	static int[] T, K;
	static boolean[] selected;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		TC = Integer.parseInt(br.readLine()); // 테케
		for (int tc = 0; tc < TC; tc++) {
			max = 0; //최댓값
			line = new StringTokenizer(br.readLine());

			N = Integer.parseInt(line.nextToken()); // 재료 수
			L = Integer.parseInt(line.nextToken()); // 제한 칼로리

			T = new int[N]; // 재료에 대한 맛의 점수
			K = new int[N]; // 재료에 대한 칼로리
			selected = new boolean[N]; // 선택했는지 체크할 배열

			for (int i = 0; i < N; i++) {
				StringTokenizer line = new StringTokenizer(br.readLine());
				T[i] = Integer.parseInt(line.nextToken());
				K[i] = Integer.parseInt(line.nextToken());
			}

			subset(0);

			System.out.println("#" + (tc + 1) + " " + max);
		}
	}

	public static void subset(int idx) {
		if (idx == N) {
			int sumK = 0;
			int sumT = 0;

			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					sumK += K[i]; // 칼로리합
					sumT += T[i]; // 맛의 점수 합
				}
			}

			// 칼로리가 1000이하
			if (sumK <= L) {
				max = Math.max(sumT, max);
			}

			return;
		}

		selected[idx] = true;
		subset(idx + 1);

		selected[idx] = false;
		subset(idx + 1);

	}

}
