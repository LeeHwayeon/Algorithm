import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {
	static int N, M, ans;
	static ArrayList<Point> chicken, home;
	static boolean[] visited;

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행렬크기
		M = Integer.parseInt(st.nextToken()); // 골라야할 치킨집 수

		chicken = new ArrayList<Point>(); // 치킨집 좌표 담을 배열
		home = new ArrayList<Point>(); // 집 좌표 담을 배열
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 2)
					chicken.add(new Point(i, j)); // 치킨집 좌표 넣기
				else if (input == 1) {
					home.add(new Point(i, j)); // 집 좌표 넣기
				}
			}
		}
		ans = Integer.MAX_VALUE;

		visited = new boolean[chicken.size()];

		combi(0, 0);

		System.out.println(ans);
	}

	public static void combi(int idx, int cnt) {
		if (cnt == M) { // 치킨집 최대 M개 고르면 리턴
			int dist = 0; // 현재 조합으로 도시치킨거리(모든집 치킨거리 누적)
			for (Point h : home) { // 집에서 가장 가까운 치킨집 찾기
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < chicken.size(); i++) {
					if (visited[i]) { // 뽑힌 치킨집들만
						int tmp = Math.abs(chicken.get(i).x - h.x) + Math.abs(chicken.get(i).y - h.y); // 치킨집과 집거리 계산
						min = Math.min(min, tmp);
					}
				}
				dist += min; // 이번 집에서 가장 가까운 치킨집까지 거리 찾았으니 누적
			}
			ans = Math.min(ans, dist);
			return;
		}
		if (idx == chicken.size()) { // 인덱스번호가 치킨집갯수라면 리턴
			return;
		}

		visited[idx] = true;
		combi(idx + 1, cnt + 1);
		visited[idx] = false;
		combi(idx + 1, cnt);

	}

}
