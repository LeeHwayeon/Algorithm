import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10818_최소최대 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
//		System.out.println(N);

		int[] array = new int[N];

		String st = br.readLine();
		StringTokenizer line = new StringTokenizer(st, " ");

		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(line.nextToken());
//			System.out.println(array[i]);
		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
			if (min > array[i]) {
				min = array[i];
			}
		}
		System.out.println(min + " " + max);
	}
}
