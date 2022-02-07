
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10974 {
	static int[] numbers;
	static int[] result; // 결과 담을 배열
	static boolean[] visited; // 방문했는지 안했는지 체크할 배열
	static int N; // 1~N
	static int num = 1;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		numbers = new int[N];
		result = new int[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			numbers[i] = num;
			num++;
		}

		sb = new StringBuilder();

		f(0);

		System.out.println(sb.toString());
	}

	public static void f(int cnt) { // cnt는 출력한 숫자 수

		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			// 만약 이미 방문했다면 다음 반복으로
			if (visited[i] == true) {
				continue;
			}

			result[cnt] = numbers[i];
			visited[i] = true; // 방문했다고 표시
			f(cnt + 1);
			visited[i] = false;
//			System.out.println(Arrays.toString(visited));
		}

	}

}
