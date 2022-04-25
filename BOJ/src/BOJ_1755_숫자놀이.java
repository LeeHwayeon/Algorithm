import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1755_숫자놀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄에 들어오기 때문에 띄어쓰기로 나눠주기
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(st.nextToken()); // M 이상
		int N = Integer.parseInt(st.nextToken()); // N 이하

		// 0~9까지 숫자를 인덱스에 맞게 영어로 저장해 놓은 배열
		String[] numSorted = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		// M~N까지 숫자를 영어로 바꿔서 저장할 배열
		String[] num = new String[N - M + 1];
		int idx = M; // M부터
		for (int i = 0; i < num.length; i++) {
			if (idx >= 10) { // 만약 10보다 크거나 같으면 두 자리수가 됨
				String s = idx + ""; // 숫자를 문자열로 바꾸고
				num[i] = numSorted[Integer.parseInt(s.charAt(0) + "")] + " "
						+ numSorted[Integer.parseInt(s.charAt(1) + "")];
			} else { // 10보다 작을때는 그냥 인덱스값에 맞춰서 값 변경해주면 됨
				num[i] = numSorted[idx];
			}
			idx++; // 다음 숫자를 위해 증가
		}

		Arrays.sort(num, new Comparator<String>() { // 문자열 정렬
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2); // o1이 사전순으로 먼저옴
			}
		});

		int count = 1; // 10줄씩 출력하기 위한 카운트 변수
		for (int i = 0; i < num.length; i++) { // 영어로 바꾼 숫자를 다시 숫자로 바꾸는 작업
			if (num[i].length() > 5) { // 길이가 5 초과하는 것은 두자리 숫자임
				st = new StringTokenizer(num[i]); // 공백을 기준으로 쪼개기
				for (int k = 0; k < 2; k++) { // 두자리 숫자이기 때문에 2번 반복
					String s1 = st.nextToken();
					for (int j = 0; j < numSorted.length; j++) {
						if (s1.equals(numSorted[j])) { // 동일한 값 찾기
							sb.append(j);
						}
					}
				}
				sb.append(" "); // 띄어쓰기
			} else {
				for (int j = 0; j < numSorted.length; j++) {
					if (num[i].equals(numSorted[j])) {
						sb.append(j + " ");
					}
				}
			}
			if (count % 10 == 0) {
				sb.append("\n"); // 10개가 되면 다음줄로
			}
			count++;
		}

		System.out.println(sb.toString()); // 출력
	}
}
