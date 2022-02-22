import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {
	static int T, N, M, parents[];
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); // 테케

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			N = Integer.parseInt(st.nextToken()); // 집합 수
			M = Integer.parseInt(st.nextToken()); // 연산 수

			parents = new int[N + 1]; // 1부터
			for (int i = 1; i <= N; i++) {
				parents[i] = i; // 집합 만들기

			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int cal = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (cal == 0) { // 합집합
					union(a, b);
				} else if (cal == 1) { // 연산
					if (findSet(a) == findSet(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			System.out.println("#" + t + " " + sb.toString());
		}
	}

	public static int findSet(int n) { // 자신의 대표자 찾기
		if (n == parents[n])
			return n; // 자신의 값이 대표자라면 자신의 값 리턴
		return parents[n] = findSet(parents[n]); // 자신의 값이 대표자가 아닐경우 parents[n]의 대표자 찾기

	}

	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) // 대표자 같을경우 안함
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

}
