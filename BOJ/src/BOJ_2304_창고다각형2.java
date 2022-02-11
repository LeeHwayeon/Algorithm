import java.util.Scanner;

public class BOJ_2304_창고다각형2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 기둥 개수
		int[] array = new int[1001];

		int max = -1;
		int maxIdx = -1;

		for (int i = 0; i < N; i++) {
			int L = sc.nextInt();
			int H = sc.nextInt();
			array[L] = H;
			if (max < array[L]) { // 최대값
				max = array[L];
				maxIdx = L;
			}
		}

		int area = 0;
		int tmpH = 0; // 기둥 높이 기억하는 변수
		for (int i = 0; i <= maxIdx; i++) { //앞에서 최대값까지
			if (tmpH < array[i]) {
				tmpH = array[i];
			}
			area += tmpH;
		}
			
		tmpH = 0;
		for (int i = 1000; i > maxIdx; i--) { //뒤에서 최대값까지
			if (tmpH < array[i]) {
				tmpH = array[i];
			}
			area += tmpH;
		}
		
		System.out.println(area);
	}

}