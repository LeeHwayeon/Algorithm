import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_3499_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케
		LinkedList<String> array1 = new LinkedList<String>();
		LinkedList<String> array2 = new LinkedList<String>();

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); // 카드 수
			StringTokenizer st = new StringTokenizer(br.readLine());

			String[] cards = new String[N]; // 카드 배열
			for (int i = 0; i < N; i++) {
				cards[i] = st.nextToken();
			}

			if (N % 2 == 0) { // N이 짝수이면
				for (int i = 0; i < (N / 2); i++) {
					array1.add(cards[i]);
				}
				for (int i = (N / 2); i < N; i++) {
					array2.add(cards[i]);
				}
			} else { // N이 홀수이면
				for (int i = 0; i < (N / 2) + 1; i++) {
					array1.add(cards[i]);
				}
				for (int i = (N / 2) + 1; i < N; i++) {
					array2.add(cards[i]);
				}
			}

			//array2 값들을 array1 홀수번호에 넣어줌
			for (int i = 0; i < array2.size(); i++) {
				array1.add((2 * i + 1), array2.get(i));
			}

			System.out.print("#" + t + " ");
			for(String s : array1) {
				System.out.print(s+" ");
			}
			System.out.println();

			// 다음 테케를 위해 삭제
			array1.clear();
			array2.clear();

		}
	}

}