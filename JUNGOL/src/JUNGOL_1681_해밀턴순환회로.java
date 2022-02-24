import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1681_해밀턴순환회로 {
	static int N, matrix[][], result[], numbers[], min;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		numbers = new int[N]; // 장소 번호를 담을 배열
		result = new int[N]; // 장소 이동 순서를 담을 배열
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = i;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;

		permu(1, 0); // 시작점은 고정되어 있으니 1부터
		System.out.println(min);

	}

	static void permu(int cnt, int sum) {
		if (cnt == N) {
			if (matrix[result[result.length - 1]][result[0]] == 0) { // 이동할 수 없어
				return;
			} else {
				sum += matrix[result[result.length - 1]][result[0]]; // 마지막에서 다시 처음으로 돌아가
				min = Math.min(min, sum);
			}
			return;
		}

		if (sum > min) { // 지금까지 더한게 min보다 크면 넘어가
			return;
		}

		for (int i = 1; i < N; i++) {
			if (visited[i])
				continue;

			result[cnt] = numbers[i];
			visited[i] = true;
			if (matrix[result[cnt - 1]][result[cnt]] == 0) { // 이동할 수 있는 방법 없을땐 제외
				visited[i] = false;
				continue;
			}
			permu(cnt + 1, sum + matrix[result[cnt - 1]][result[cnt]]);
			visited[i] = false;
		}
	}

}
