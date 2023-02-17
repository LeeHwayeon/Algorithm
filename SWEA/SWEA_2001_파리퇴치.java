import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001_파리퇴치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int sum = 0; //M개 영역에 존재하는 파리 합
			int max = Integer.MIN_VALUE; // 최댓값
			StringTokenizer line = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(line.nextToken());
			int M = Integer.parseInt(line.nextToken()); //파리채

			int[][] array = new int[N][N];

			for (int i = 0; i < N; i++) {
				String[] arrayline = br.readLine().split(" "); //공백을 기준으로 나눠서 String 배열에 저장
				for (int j = 0; j < N; j++) {
					array[i][j] = Integer.parseInt(arrayline[j]); //String배열을 2차원배열에 넣어줌
				}
			}
			// 배열 잘 담겼는지 확인
//			for(int[] a : array) {
//				for(int aa: a) {
//					System.out.print(aa+" ");
//				}
//				System.out.println();
//			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					//5*5배열에서 M이 2라면, i와 j는 M-1만큼 움직이면서 더할 수 있음 
					//따라서 i와 j에 M-1을 더한 값이 N보다 작아야 한다.
					//현재 행,열에서 M-1값을 더한 값이 N보다 작을때
					if(i+(M-1)<N && j+(M-1)<N) {
						//x와 y는 현재 i와 j에 M을 더한 값보다 작을때까지 움직임(M-1만큼 움직일 수 있어서 미만)
						for(int x=i; x<i+M; x++) {
							for(int y=j; y<j+M; y++) {
								sum += array[x][y];
								if(sum > max) {
									max = sum;
								}
//								System.out.println("sum : "+sum);
//								System.out.println("max : "+max);
							}
						}
						sum = 0; //합 초기화
					}
				}
			}
			System.out.println("#"+(t+1)+" "+max);
			
		}

	}

}
