import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스문제 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // N번
		int K = Integer.parseInt(st.nextToken()); // 삭제할 번호

		LinkedList<Integer> list = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		System.out.print("<");
		while (list.size() !=1) { //한 개 남기 전까지
			for (int i = 0; i < K; i++) { //K번 전까지 돌리면서 
				if (i == K - 1) { //인덱스는 0부터시작하니까 K-1이 i랑 같을때 삭제
					System.out.print(list.remove()+", ");
				} else { //그렇지 않을떄는 삭제할것을 뒤로 add
					list.add(list.remove()); 
				}
			}
		}
		System.out.print(list.remove()+">"); //하나남았으니까 같이 출력

	}

}