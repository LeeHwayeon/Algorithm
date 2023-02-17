import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5432_쇠막대기자르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();

			int count = 0; // 막대기 개수
			int sum = 0; // 잘려진 조각 총 개수

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(' && str.charAt(i + 1) == ')') { // 레이저일때
					sum += count; // 막대기 개수만큼 증가
					i++; // 레이저끝난 다음으로 넘어가게
				} else if (str.charAt(i) == '(') { // 막대기 여는 괄호
					count++; // 막대기 개수 증가
				} else { // 막대기 닫는 괄호
					count--; // 막대기 개수 감소
					sum++; // 자르고 남은 막대기 조각
				}
			}
			System.out.println("#" + tc + " " + sum);
		}

	}// end main

}
