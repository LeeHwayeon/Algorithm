import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654_랜선자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] array = new int[K];

		for (int i = 0; i < K; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(array);

		long low = 1;
		long high = array[K - 1];
		long mid = 0;

		while (low <= high) {
			mid = (low + high) / 2;
			int sum = 0;

			for (int i = 0; i < K; i++) {
				sum += array[i] / mid;
			}

			if (sum >= N) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(high);
	}

}
