import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2577_숫자의개수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		int[] count = new int[10];

		int result = a * b * c;
		// int를 문자열로 바꾸는 가장 쉬운 방법은 빈문자를 붙이면 된다!
		String st = result + "";
//		String st = Integer.toString(result);

//		System.out.println(result);

		for (int i = 0; i < st.length(); i++) {
			int idx = st.charAt(i) - '0';
			count[idx]++;
		}

		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}

	}

}
