import java.util.Scanner;

public class BOJ_2810_컵홀더 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String s = sc.next();

		int cntS = 0, cntL = 0;
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == 'S') {
				cntS++;
			} else {
				cntL++;
			}
		}
		if (cntL > 0) {
			System.out.println(cntS + (cntL / 2) + 1);
		} else {
			System.out.println(cntS);
		}
	}

}
