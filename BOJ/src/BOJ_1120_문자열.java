import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1120_문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		int Alen = A.length();
		int Blen = B.length();

		int cnt = 0; // 차이 횟수
		if (Alen == Blen) { // 길이가 같으면 A 앞,뒤에 알파벳 추가할 수 없기 때문에 바로 비교
			for (int i = 0; i < Alen; i++) {
				if (A.charAt(i) != B.charAt(i)) {
					cnt++;
				}
			}
		} else {
			if (B.contains(A)) { // 만약 B에 A문자가 포함되어 있으면 똑같은 알파벳을 앞뒤로 추가해주면 되기 때문에 횟수 0
				cnt = 0;
			} else {
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < (Blen - Alen) + 1; i++) { // A와 B길이의 차의 +1만큼 반복
					int idx = 0; // A는 무조건 처음부터 비교해야하기 때문에 인덱스 변수 사용
					cnt = 0;
					for (int j = i; j < (Alen + i); j++) { // B는 비교 시작위치를 한칸씩 옮겨야 함
						if (A.charAt(idx++) != B.charAt(j)) {
							cnt++;
						}
					}
					min = Math.min(min, cnt);
				}
				cnt = min;
			}
		}
		System.out.println(cnt);
	}

}
