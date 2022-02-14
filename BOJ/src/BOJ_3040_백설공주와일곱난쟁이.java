import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3040_백설공주와일곱난쟁이 {
	static int[] numbers, result;
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		numbers = new int[9];
		result = new int[7];
		for (int i = 0; i < 9; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
//		System.out.println(Arrays.toString(numbers));

		comb(0, 0);

	}

	public static void comb(int cnt, int start) {
		if (cnt == 7) { // 7명 다 뽑았을 때 리턴
//			System.out.println(Arrays.toString(result));
			sum = 0;
			for (int i = 0; i < result.length; i++) {
				sum += result[i];
			}
			if (sum == 100) {
				for (int n : result) {
					System.out.println(n);
				}
			}
			return;
		}

		for (int i = start; i < numbers.length; i++) {
			result[cnt] = numbers[i];
			comb(cnt + 1, i + 1);
		}
	}

}
