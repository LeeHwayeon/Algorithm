import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			System.out.println(binary(Integer.parseInt(st.nextToken()), 0, N - 1, numbers));
		}
	}

	public static int binary(int key, int low, int high, int[] numbers) {
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;

			if (key == numbers[mid]) {
				return 1;
			} else if (key < numbers[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return 0;
	}

}
