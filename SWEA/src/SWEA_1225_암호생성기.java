import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1225_암호생성기 {
	static int T;
	static LinkedList<Integer> array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			T = Integer.parseInt(br.readLine()); // 테케
			array = new LinkedList<Integer>();

			StringTokenizer line = new StringTokenizer(br.readLine());

			for (int i = 0; i < 8; i++) {
				array.add(Integer.parseInt(line.nextToken()));
			}
			
			//마지막값이 0일때까지 반복문 돌린다
			while (array.peekLast() != 0) {
				for (int i = 1; i <= 5; i++) { //5까지 감소한게 사이클 1
					int num = array.peekFirst();
					if ((num - i) <= 0) { //첫번쨰값에서 i를 뺀게 0보다 작거나 같을때
						array.add(0); //마지막 값을 0으로 만듦
						array.removeFirst(); //첫번째값을 뺌
						break; //마지막값이 0일때 반복문 종료
					} else {
						array.add(num - i);
						array.removeFirst();
					}
				}
			}
			
			System.out.print("#"+t+" ");
			for (Integer n : array) {
				System.out.print(n+" ");
			}
			System.out.println();
		
		}
	}

}