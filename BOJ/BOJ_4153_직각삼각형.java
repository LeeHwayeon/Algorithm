import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4153_직각삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer line = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(line.nextToken());
			int b = Integer.parseInt(line.nextToken());
			int c = Integer.parseInt(line.nextToken());

			if (a == 0 && b == 0 && c == 0) {
				break;
			}

			if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
				System.out.println("right");
			} else if (Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2)) {
				System.out.println("right");
			} else if (Math.pow(c, 2) + Math.pow(a, 2) == Math.pow(b, 2)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}

		}
	}

}
