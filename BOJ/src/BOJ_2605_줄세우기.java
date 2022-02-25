import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2605_줄세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1~N 번호

		List<Integer> list = new ArrayList<Integer>();
		list.add(0); // 번호가 1번부터라 0번인덱스 비워놓고 시작하기 위해 미리 집어넣음

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == 0) { // 그 자리에 그대로
				list.add(i, i);
			} else {
				list.add(i - num, i);
			}
		}
		for (int i = 1; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
