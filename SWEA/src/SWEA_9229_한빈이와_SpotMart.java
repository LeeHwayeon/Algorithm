import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229_한빈이와_SpotMart {
	static int N, M, TC, max, sum;
	static int[] snack, result;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		TC = Integer.parseInt(br.readLine()); // 테케

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer line = new StringTokenizer(br.readLine());

			N = Integer.parseInt(line.nextToken()); // 과자봉지 수
			M = Integer.parseInt(line.nextToken()); // 과지봉지 무게

			snack = new int[N]; // 과자 봉지 무게 입력받을 배열
			result = new int[2]; // 결과를 담을 배열
			visited = new boolean[N]; // 방문 확인할 배열
			max = -1; // 과자 들고 갈 방법 없는 경우로 세팅

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < snack.length; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}

			comb(0);

			System.out.println("#" + tc + " " + max);

		}
	}

	// N개 중에 2개 뽑아서 무게 비교
	public static void comb(int cnt) {
		if (cnt == 2) { // 2개 다 뽑았으면
			sum = 0;
			for (int n : result) {
				sum += n; // 뽑은 과자 무게 더하기
			}
			if (sum <= M) { // 과자 제한 무게보다 작거나 같은 경우에만 비교
				max = Math.max(sum, max);
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) { // 만약 이미 뽑은 과자라면
				continue;
			}

			result[cnt] = snack[i];
			visited[i] = true;
			comb(cnt + 1);

			visited[i] = false;

		}

	}

}