import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14891_톱니바퀴 {
	static int K, no, d, map[][];
	static ArrayList<Integer> clockwise, counterClockwise;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[4][8];

		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = Integer.parseInt(s.charAt(j) + "");
			}
		}

		K = Integer.parseInt(br.readLine()); // 회전 횟수
		for (int i = 0; i < K; i++) {
			clockwise = new ArrayList<Integer>(); // 시계방향
			counterClockwise = new ArrayList<Integer>(); // 반시계방향
			StringTokenizer st = new StringTokenizer(br.readLine());
			no = Integer.parseInt(st.nextToken()) - 1; // 톱니바퀴 번호
			d = Integer.parseInt(st.nextToken()); // 방향

			if (d == 1) { // 현재 톱니바퀴도 회전해야함
				clockwise.add(no);
			} else {
				counterClockwise.add(no);
			}

			findRotation(no, d); // 회전할 톱니바퀴 찾기

			for (Integer num : clockwise) { // 시계방향 회전
				int tmp = map[num][7];
				for (int j = 7; j > 0; j--) {
					map[num][j] = map[num][j - 1];
				}
				map[num][0] = tmp;
			}
			for (Integer num : counterClockwise) { // 반시계방향 회전
				int tmp = map[num][0];
				for (int j = 1; j < 8; j++) {
					map[num][j - 1] = map[num][j];
				}
				map[num][7] = tmp;
			}
		}

		int sum = 0;
		for (int j = 0; j < 4; j++) { // 점수 계산
			if (map[j][0] == 1) {
				sum += Math.pow(2, j);
			}
		}
		System.out.println(sum);
	}

	public static void findRotation(int no, int d) {
		int gNo = no;
		int direction = d;
		while (gNo != 3) {
			if (map[gNo][2] != map[gNo + 1][6]) { // 맞닿은 극이 다름 회전해야함
				if (direction == -1) { // 반시계이면 시계에 넣음
					clockwise.add(gNo + 1);
					direction = 1;
				} else { // 시계이면 반시계에 넣음
					counterClockwise.add(gNo + 1);
					direction = -1;
				}
				gNo++;
			} else { // 맞닿은 극이 같음 회전 안해도 됨
				break;
			}
		}

		gNo = no;
		direction = d;
		while (gNo != 0) {
			if (map[gNo - 1][2] != map[gNo][6]) {
				if (direction == -1) { // 반시계
					clockwise.add(gNo - 1);
					direction = 1;
				} else {
					counterClockwise.add(gNo - 1);
					direction = -1;
				}
				gNo--;
			} else {
				break;
			}
		}
	}
}
