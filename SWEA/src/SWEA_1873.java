import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			char[][] game = new char[H][W];

			for (int i = 0; i < H; i++) {
				String array = br.readLine();
				game[i] = array.toCharArray();
			}

			// 전차가 있는 i,j를 찾기 위해
			int indexI = 0, indexJ = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (game[i][j] == '^' || game[i][j] == 'v' || game[i][j] == '<' || game[i][j] == '>') {
						indexI = i;
						indexJ = j;
					}
				}
			}
//			System.out.println(indexI+","+indexJ);

			int N = Integer.parseInt(br.readLine());
			String user = br.readLine();
			char[] userInput = user.toCharArray();
//			System.out.println(userInput);

			for (int i = 0; i < N; i++) {
//				System.out.println(userInput[i]);
				if (userInput[i] == 'U') {
					game[indexI][indexJ] = '^'; // 일단 방향을 바꾼다
					// 위쪽이 맵 밖이 아닐때
					if (indexI - 1 >= 0) {
						// 위쪽이 평지일때
						if (game[indexI - 1][indexJ] == '.') {
							game[indexI - 1][indexJ] = '^';
							game[indexI][indexJ] = '.';
							indexI = indexI - 1;
//						System.out.println("U : "+game[indexI][indexJ]);							
						}
					}
				} else if (userInput[i] == 'D') {
					game[indexI][indexJ] = 'v';
					// 맵 밖이 아니고
					if (indexI + 1 < H) {
						//아래가 평지일때 
						if (game[indexI + 1][indexJ] == '.') {
							game[indexI + 1][indexJ] = 'v';
							game[indexI][indexJ] = '.';
							indexI = indexI + 1;
//						System.out.println("D : "+game[indexI][indexJ]);
						}
					}
				} else if (userInput[i] == 'L') {
					game[indexI][indexJ] = '<';
					// 맵 밖이 아니고
					if (indexJ - 1 >= 0) {
						//왼쪽이 평지일때
						if (game[indexI][indexJ - 1] == '.') {
							game[indexI][indexJ - 1] = '<';
							game[indexI][indexJ] = '.';
							indexJ = indexJ - 1;
//						System.out.println("L : "+game[indexI][indexJ]);
						}
					}
				} else if (userInput[i] == 'R') {
					game[indexI][indexJ] = '>';
					if (indexJ + 1 < W) {
						if (game[indexI][indexJ + 1] == '.') {
							game[indexI][indexJ + 1] = '>';
							game[indexI][indexJ] = '.';
							indexJ = indexJ + 1;
//						System.out.println("R : "+game[indexI][indexJ]);
						}
					}
				} else if (userInput[i] == 'S') {
					if (game[indexI][indexJ] == '^') {
						// 포탄 위로 직진하니까 indexI--, 맵으로 나가기 전까지?
						for (int p = indexI - 1; p >= 0; p--) {
							// 벽돌 벽은 평지가 됨
							if (game[p][indexJ] == '*') {
								game[p][indexJ] = '.';
								break; // 벽에 부딪히면 포탄 소멸하니까 반복문 탈출
							} else if (game[p][indexJ] == '#') {
								break;
							}
//							System.out.println("S : "+game[p][indexJ]);
						}
					} else if (game[indexI][indexJ] == 'v') {
						for (int p = indexI + 1; p < H; p++) {
							// 벽돌 벽은 평지가 됨
							if (game[p][indexJ] == '*') {
								game[p][indexJ] = '.';
								break;
							} else if (game[p][indexJ] == '#') {
								break;
							}
//							System.out.println("S : "+game[p][indexJ]);
						}
					} else if (game[indexI][indexJ] == '<') {
						for (int p = indexJ - 1; p >= 0; p--) {
							// 벽돌 벽은 평지가 됨
							if (game[indexI][p] == '*') {
								game[indexI][p] = '.';
								break;
							} else if (game[indexI][p] == '#') {
								break;
							}
//							System.out.println("S : "+game[indexI][p]);
						}
					} else if (game[indexI][indexJ] == '>') {
						for (int p = indexJ + 1; p < W; p++) {
							// 벽돌 벽은 평지가 됨
							if (game[indexI][p] == '*') {
								game[indexI][p] = '.';
								break;
							} else if (game[indexI][p] == '#') {
								break;
							}
//							System.out.println("S : "+game[indexI][p]);
						}
					}
				}
//				System.out.println(userInput[i] + " " + i + "--------------------");
//				for (char[] chars : game) {
//					for (char c : chars) {
//						System.out.print(c);
//					}
//					System.out.println();
//				}
			}
			System.out.print("#" + (t + 1) + " ");
			for (char[] chars : game) {
				for (char c : chars) {
					System.out.print(c);
				}
				System.out.println();
			}

		}
	}

}
