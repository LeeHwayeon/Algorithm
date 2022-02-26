import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2851_슈퍼마리오 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;
		int idx = 0;
		int[] abs = new int[10];
		int[] numbers = new int[10];
		for (int i = 0; i < 10; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
			sum += numbers[i];
			abs[i] = Math.abs(100 - sum);
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			if (min > abs[i]) {
				min = abs[i];
				idx = i;
			} else if (min == abs[i]) {
				idx = i;
			}
		}
		
		sum = 0;
		for(int i=0; i<=idx; i++) {
			sum += numbers[i];
		}
		System.out.println(sum);
	}

}
