import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL_1828_냉장고 {

	public static class Refrigerator implements Comparable<Refrigerator> {
		int low; // 최저온도
		int high; // 최고온도

		public Refrigerator(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Refrigerator o) {
			// 최고 온도를 기준으로 정렬
			// 만약 최고 온도가 같다면 최저 온도를 기준으로 정렬한다
			return this.high - o.high != 0 ? this.high - o.high : this.low - o.low;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = StoI(br.readLine());
		Refrigerator[] ref = new Refrigerator[N];

		for (int n = 0; n < N; n++) {
			StringTokenizer line = new StringTokenizer(br.readLine());

			ref[n] = new Refrigerator(StoI(line.nextToken()), StoI(line.nextToken()));
		}

		int count = 1; // 냉장고 수
		Arrays.sort(ref); // 정렬
		int maxTemp = ref[0].high; // 배열의 0번째 값의 최고온도 저장
		for (int i = 1; i < ref.length; i++) {
			if (ref[i].low > maxTemp) { // 배열의 첫번째 값의 최저온도가 최고온도보다 크다면 온도 업데이트
				maxTemp = ref[i].high;
				count++;
			}
		}
		System.out.println(count);

	}

	public static int StoI(String s) { // String -> int
		return Integer.parseInt(s);
	}

}
