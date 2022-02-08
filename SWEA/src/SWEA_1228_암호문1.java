import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1228_암호문1 {
	static int N, C;
	static LinkedList<Integer> original = new LinkedList<Integer>();
	static LinkedList<Integer> s = new LinkedList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {

			N = Integer.parseInt(br.readLine()); // 원본 암호문 길이
			StringTokenizer o = new StringTokenizer(br.readLine()); // 원본 암호문 문자열
			// 원본 암호문 리스트에 넣기
			for (int n = 0; n < N; n++) {
				original.add(Integer.parseInt(o.nextToken()));
			}

			C = Integer.parseInt(br.readLine()); // 명령어 개수
			StringTokenizer line = new StringTokenizer(br.readLine(), "I"); //명령어를 I를 기준으로 자르기
			
			for (int c = 0; c < C; c++) {
				StringTokenizer st = new StringTokenizer(line.nextToken()); //I를 기준으로 자른 명령어를 또 자른다

				int x = Integer.parseInt(st.nextToken()); // 삽입될 위치
				int y = Integer.parseInt(st.nextToken()); // 삽입될 숫자 개수

//				System.out.println("x :" + x + " y:" + y);
				
				for (int i = 0; i < y; i++) {
					s.add(Integer.parseInt(st.nextToken()));
				}

				original.addAll(x, s); // x위치 바로 다음에 s 넣기
				s.clear(); //s는 덧붙일 숫자들이기 때문에 이전값 삭제해줘야함 

			}
			System.out.print("#"+tc+" ");
			int idx = 0;
			for (Integer i : original) {
				idx++;
				System.out.print(i+" ");
				if (idx == 10) {
					break;
				}
			}
			System.out.println();
			
			//이전 값들 다 삭제
			original.clear();
			s.clear();

		}
	}

}