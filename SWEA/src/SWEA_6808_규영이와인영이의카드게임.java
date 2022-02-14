import java.util.Arrays;
import java.util.Scanner;

public class SWEA_6808_규영이와인영이의카드게임 {
	static int T, win, lose;
	static int[] numbers, gyu, in, result;
	static boolean[] numCheck, visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt(); // 테케
		for (int t = 1; t <= T; t++) {
			numCheck = new boolean[19]; // 1~18 t/f 체크할 배열
			numbers = new int[19]; // 1~18담을 배열 0인덱스는 비워놓을거라서 크기 19
			for (int i = 1; i < numbers.length; i++) {
				numbers[i] = i; // numbers 배열에 1~18 집어넣기
			}

//			System.out.println(Arrays.toString(numbers));

			gyu = new int[9]; // 규영이 카드
			in = new int[9]; // 인영이 카드
			visited = new boolean[9]; // 인영이 카드 순서 방문 확인할 배열
			result = new int[9]; // 인영이 카드 순서 담을 배열

			for (int i = 0; i < 9; i++) { // 입력받는 값을 규영이 카드배열에 넣어줌
				gyu[i] = sc.nextInt();
				numCheck[gyu[i]] = true; // 해당 값을 true 처리
			}

//			System.out.println(Arrays.toString(gyu));
//			System.out.println(Arrays.toString(numCheck));

			int idx = 0;
			for (int i = 1; i < numCheck.length; i++) {
				if (!numCheck[i]) { // 규영이가 카드 낸거 제외한 카드를
					in[idx++] = numbers[i]; // 인영이 카드에 집어넣는다
				}
			}

//			System.out.println(Arrays.toString(in));
//			System.out.println("====================");
			
			win = 0; lose = 0;

			cards(0);
			System.out.println("#"+t+" "+win+" "+lose);
		}

	}

	public static void cards(int cnt) {
		if (cnt >= 9) {
			int sumGyu=0, sumIn=0;
			for (int k = 0; k < 9; k++) {
				if (gyu[k] > result[k]) { // 규영카드>인영카드
					sumGyu += gyu[k]+result[k];
				}else {
					sumIn += gyu[k]+result[k];
				}
			}
			if(sumGyu>sumIn) { //규영이가 이겼을때
				win++;
			}else if(sumGyu<sumIn) {
				lose++;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (visited[i])
				continue;

			result[cnt] = in[i];
			visited[i] = true;
			cards(cnt + 1);

			visited[i] = false;
		}
	}

}
