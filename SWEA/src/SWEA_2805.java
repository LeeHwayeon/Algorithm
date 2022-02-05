package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine()); // 농장크기
			int[][] farm = new int[N][N];
			int sum = 0; // 수익 합

			// 입력 배열에 집어 넣기
			for (int i = 0; i < N; i++) {
				String[] arr = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					farm[i][j] = Integer.parseInt(arr[j]);
				}
			}

			int startJ = N / 2; // 열 시작 변수
			int endJ = N / 2; // 열 끝 변수

			for (int i = 0; i < N; i++) {
				for (int j = startJ; j <= endJ; j++) {
					sum += farm[i][j];
//					System.out.println(i+" "+j+" "+sum);
				}
				//행이 0~N/2일때 
				if (i < (N / 2)) {
					startJ--;
					endJ++;
				}else {
					startJ++;
					endJ--;
				}
//				System.out.println("startJ "+startJ+"endJ "+endJ);
			}
			
			System.out.println("#"+(t+1)+" "+sum);

		}
	}

}
