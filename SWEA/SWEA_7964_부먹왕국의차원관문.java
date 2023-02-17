import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7964_부먹왕국의차원관문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());

			int count = 0;
			int ans = 0;
			for (int n = 0; n < N; n++) {
				if (Integer.parseInt(st.nextToken()) == 0) {
					count++;
					if (count == D) {
						count = 0;
						ans++;
					}
				} else {
					count = 0;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
