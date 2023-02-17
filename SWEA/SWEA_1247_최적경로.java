import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로 {
	static int N, company[], home[], result[], input[], min;
	static List<int[]> customer;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 고객 수
			visited = new boolean[N]; // 방문 확인 배열
			min = Integer.MAX_VALUE; // 최솟값

			StringTokenizer line = new StringTokenizer(br.readLine());
			company = new int[] { Integer.parseInt(line.nextToken()), Integer.parseInt(line.nextToken()) }; //처음 두개가 회사 좌표 
			home = new int[] { Integer.parseInt(line.nextToken()), Integer.parseInt(line.nextToken()) }; //그 다음 두개가 집 좌표

			result = new int[N]; // 순열 결과 담을 배열
			customer = new ArrayList<>();
			for (int n = 0; n < N; n++) {
				customer.add(new int[] { Integer.parseInt(line.nextToken()), Integer.parseInt(line.nextToken()) });
			}

			delivery(0);

			System.out.println("#" + t + " " + min);

		}
	}

	public static void delivery(int cnt) {
		if (cnt == N) { // 고객 수만큼 조합 다했을 때
			min = Math.min(cal(result), min); // x좌표, y좌표 더한거랑 최솟값 비교
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			result[cnt] = i;
			visited[i] = true;
			delivery(cnt + 1);

			visited[i] = false;
		}

	}

	public static int cal(int[] result) {
		int x = 0, y = 0, sum = 0;
		x += Math.abs(company[0] - customer.get(result[0])[0]); // 회사->첫번째 고객
		y += Math.abs(company[1] - customer.get(result[0])[1]);
		for (int i = 0; i < result.length - 1; i++) {
			x += Math.abs(customer.get(result[i])[0] - customer.get(result[i + 1])[0]); // x좌표 차이
			y += Math.abs(customer.get(result[i])[1] - customer.get(result[i + 1])[1]); // y좌표 차이
		}
		x += Math.abs(home[0] - customer.get(result[result.length - 1])[0]); // 마지막 고객 -> 집
		y += Math.abs(home[1] - customer.get(result[result.length - 1])[1]);
		sum = x + y;
		return sum;
	}

}
