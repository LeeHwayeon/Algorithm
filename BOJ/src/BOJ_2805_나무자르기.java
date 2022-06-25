import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(trees);

		long low = 0;
		long high = trees[N - 1];

		while (low <= high) {
			long mid = (low + high) / 2;
			long sum = 0;

			for (int tree : trees) {
				if (tree > mid) {
					sum += tree - mid;
				}
			}

			if (sum >= M) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(high);
	}
}
