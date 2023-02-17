import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309_일곱난쟁이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] numbers = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
			sum += numbers[i];
		}
		Arrays.sort(numbers);

		int num = sum - 100; // 9개 수 다 더한 값에서 100빼면 나오는수 저장
		for (int i = 0; i < 9; i++) { // 일곱난쟁이를 찾기 위해서 숫자 2개를 더해서 num이 되는 것을 찾는다.
			for (int j = i + 1; j < 9; j++) {
				if (numbers[i] + numbers[j] == num) { // 찾으면 값을 0으로 바꿔버리기
					numbers[i] = 0;
					numbers[j] = 0;
					for (int k = 0; k < 9; k++) {
						if (numbers[k] != 0) {
							System.out.println(numbers[k]);
						}
					}
					return;
				}
			}
		}
	}

}
