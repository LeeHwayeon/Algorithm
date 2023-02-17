import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3985_롤케이크 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine()); // 롤케이크 길이
		int N = Integer.parseInt(br.readLine()); // 방청객 수
		int[] rollcake = new int[L + 1]; // 롤케이크 길이 1부터여서 +1

		int max = Integer.MIN_VALUE, maxIdx = -1;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			if (max < (num2 - num1)) { // 가장 많은 조각을 맏을 것으로 기대하고 있던 방청객
				max = num2 - num1;
				maxIdx = i;
			}
			for (int j = num1; j <= num2; j++) { // num1번 조각부터 num2번 조각까지 방척객 번호 넣기
				if (rollcake[j] == 0) { // 만약 비어있었다면
					rollcake[j] = i; // 해당 방청객 번호 넣기
				}
			}
		}

		int[] count = new int[N + 1]; // 각 방청객이 케이크 몇조각 받는지 저장할 배열
		for (int i = 1; i <= L; i++) {
			for (int j = 1; j <= N; j++) {
				if (rollcake[i] == j) {
					count[j]++;
				}
			}
		}
		int ans = 0; // 실제로 가장 많은 조각을 받을 방청객 저장 변수
		int ansIdx = 0;
		for (int i = 1; i <= N; i++) {
			if (ans < count[i]) {
				ans = count[i];
				ansIdx = i;
			}
		}
		System.out.println(maxIdx);
		System.out.println(ansIdx);
	}
}
