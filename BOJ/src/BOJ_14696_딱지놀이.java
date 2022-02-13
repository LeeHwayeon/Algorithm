import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14696_딱지놀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 총 라운드 수

		for (int n = 0; n < N; n++) {
			int A = sc.nextInt();
			int[] a = new int[5];
			int[] b = new int[5];
			
			for (int i = 0; i < A; i++) {
				int num = sc.nextInt();
				switch(num) {
				case 1 : a[1]++; break;
				case 2 : a[2]++; break;
				case 3 : a[3]++; break;
				case 4 : a[4]++; break;
				}
			}

			int B = sc.nextInt();
			for (int i = 0; i < B; i++) {
				int num = sc.nextInt();
				switch(num) {
				case 1 : b[1]++; break;
				case 2 : b[2]++; break;
				case 3 : b[3]++; break;
				case 4 : b[4]++; break;
				}			
			}
			
//			System.out.println(Arrays.toString(a));
//			System.out.println(Arrays.toString(b));
			
			if(a[4] == b[4]) { // 별 개수 같음
				if(a[3] != b[3]) { // 동그라미 개수 다름
					if(a[3]>b[3]) { //a어린이의 동그라미 개수가 b어린이 동그라미 개수보다 많을 때
						System.out.println("A"); 
					}else {
						System.out.println("B");
					}
				}else {// 별 개수 같음 & 동그라미 개수 같음
					if(a[2] != b[2]) { //네모 개수 다름
						if(a[2]>b[2]) { //a어린이의 네모 개수가 b어린이 네모 개수보다 많을 때
							System.out.println("A"); 
						}else {
							System.out.println("B"); 
						}		
					}else { // 별 개수 같음 & 동그라미 개수 같음 & 네모 개수 같음
						if(a[1] != b[1]) { //세모 개수 다름
							if(a[1]>b[1]) { //a어린이의 세모 개수가 b어린이 세모 개수보다 많을 때
								System.out.println("A");
							}else {
								System.out.println("B");
							}
						}else { // 별 개수 같음 & 동그라미 개수 같음 & 네모 개수 같음 & 세모 개수 같음 
							System.out.println("D"); //무승부
						}
					}
				}
			}else { //별 개수 다를 때
				if(a[4]>b[4]) { //a어린이의 별 개수가 b어린이 별 개수보다 많을 때
					System.out.println("A");
				}else {
					System.out.println("B");
				}
			}

			
		}
	}

}