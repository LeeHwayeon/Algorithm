import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3052_나머지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		boolean[] namerge = new boolean[42];
//		
//		for(int i=0; i<10; i++) {
//			namerge[Integer.parseInt(br.readLine()) % 42 ] = true;
//		}
//		
//		int count = 0;
//		
//		for(int i=0; i<namerge.length; i++) {
//			if(namerge[i] == true) {
//				count++;
//			}
//		}
//		System.out.println(count);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int[] numArray = new int[10];
		boolean[] numArray = new boolean[42];
		
		
		for(int i=0; i<10; i++) {
			int n = Integer.parseInt(br.readLine())%42;
			numArray[n] = true;
		}
		
		int count = 0;
		for(int i=0; i<numArray.length; i++) {
			if(numArray[i] == true)
				count++;
		}
		System.out.println(count);
	}

}
