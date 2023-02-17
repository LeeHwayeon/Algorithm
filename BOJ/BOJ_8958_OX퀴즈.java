import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958_OX퀴즈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int TC = Integer.parseInt(br.readLine());
//		
//		int count = 0;
//		int sum = 0;
//		
//		for(int i=0; i<TC; i++) {
//			//readLine()은 여러줄을 읽지 않고 한줄만 읽기 때문에 반복문 안에서 돌려줘야 함!
//			String line = br.readLine();			
//			for(int j=0; j<line.length(); j++) {
//				if(line.charAt(j) == 'O') {
//					count++;
////					System.out.println("count"+count);
//				}else {
//					count = 0;
//				}
//				sum = sum + count;
//			}
//			System.out.println(sum);
//			count = 0;
//			sum = 0;
//		}
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int i=0; i<TC; i++) {
			String str = br.readLine();
//			StringTokenizer line = new StringTokenizer(str);
			
			int count = 0;
			int sum = 0;
			
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) == 'O') {
					count++;
				}else {
					count = 0;
				}
				sum += count;
			}
			System.out.println(sum);
		}

		
	}
}
