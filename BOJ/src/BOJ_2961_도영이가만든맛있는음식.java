import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식 {
	static int N, S, B, min;
	static boolean[] visited;
	static List<int[]> cook;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 재료 개수
		visited = new boolean[N]; // 방문 확인할 배열

		cook = new ArrayList<int[]>();

		for (int n = 0; n < N; n++) {
			StringTokenizer line = new StringTokenizer(br.readLine());
			S = Integer.parseInt(line.nextToken()); // 신맛
			B = Integer.parseInt(line.nextToken()); // 쓴맛

			cook.add(new int[] { S, B }); // 신맛과 쓴맛을 저장한 배열을 리스트에 저장
		}

//		for (int i = 0; i < cook.size(); i++) {
//			System.out.println(cook.get(i)[0]);
//			System.out.println(cook.get(i)[1]);
//		}

		min = Integer.MAX_VALUE; // 최솟값

		subset(0);

		System.out.println(min);
	}

	public static void subset(int cnt) {
		if (cnt == N) { // 원소 다 선택했을 때
			int sumS = 1, sumB = 0; // 신맛은 곱하기니까 1 쓴맛은 더하기니까 0
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
//					System.out.println(cook.get(i)[0]);
//					System.out.println(cook.get(i)[1]);
					sumS *= cook.get(i)[0]; // 선택된 원소 신맛 곱하기
					sumB += cook.get(i)[1]; // 선택된 원소 쓴맛 더하기
				}
			}
//			System.out.println("sumS : " + sumS + " sumB : " + sumB);
			if (sumS != 1 && sumB != 0) { // 공집합을 제외하기 위해
				min = Math.min(Math.abs(sumB - sumS), min); // 신맛과 쓴맛 차이가 가장 작은 요리 뽑기
			}
			return;
		}

		visited[cnt] = true;
		subset(cnt + 1);

		visited[cnt] = false;
		subset(cnt + 1);
	}

}
