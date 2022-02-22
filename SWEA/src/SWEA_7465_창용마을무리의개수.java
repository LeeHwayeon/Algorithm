import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_7465_창용마을무리의개수 {
	public static int findSet(int n) {
		if (n == parents[n])
			return n;
		return parents[n] = findSet(parents[n]);
	}

	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	static int T, N, M, parents[], result[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); // 테케
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 마을에 사는 사람 수
			M = Integer.parseInt(st.nextToken()); // 관계 수

			parents = new int[N + 1]; // 사람수는 1부터
			result = new int[N]; // 무리를 만들고 난 후 각 부모를 담을 배열
			for (int i = 1; i <= N; i++) {
				parents[i] = i; // 부모 채우기
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				union(from, to); // 무리 만들기
			}
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 1; i <= N; i++) {
				if (list.isEmpty()) { // 비어있으면 찾은 부모를 리스트에 넣음
					list.add(findSet(parents[i]));
				} else { // 비어 있지 않으면
					if (list.contains(findSet(parents[i]))) { // 찾은 부모 값이 이미 리스트안에 있으면 다음 반복문 넘어감
						continue;
					} else { // 리스트에 없으면 넣음
						list.add(findSet(parents[i]));
					}
				}
			}

			System.out.println("#" + t + " " + list.size());
		}

	}

}
