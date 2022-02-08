import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {
	static int N; // 탑의 수
	static Stack<int[]> top; // top배열
	static int num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		top = new Stack<int[]>();

		StringTokenizer line = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			num = Integer.parseInt(line.nextToken());

			// top 배열안에 데이터가 있을 때
			while (!top.isEmpty()) {
				if (top.peek()[1] >= num) { // 현재 탑보다 이전 탑 높이가 크면
					System.out.print(top.peek()[0]+" "); //이전탑 출력
					break;
				} else {
					top.pop(); //작으면 필요없으니 삭제
				}
			}
			
			// top 배열안에 데이터 없을 때
			if(top.isEmpty()) {
				System.out.print(0+" ");
			}
			
			top.push(new int[] {i, num});

		}
	}

}

