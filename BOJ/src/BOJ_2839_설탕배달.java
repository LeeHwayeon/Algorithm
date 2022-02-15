import java.util.Scanner;

public class BOJ_2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 배달해야하는 설탕 무게
		int count = 0;

		while (N > 0) {
			// 가장 적은 봉지 개수 찾기
			if (N % 5 == 0) { // 5로 나눠 떨어질때
				count++;
				N -= 5;
			} else if (N % 3 == 0) { // 3으로 나눠 떨어질때
				count++;
				N -= 3;
			} else if (N > 5) { //3의 배수, 5의 배수가 아닐때 5보다 크면 일단 5를 빼준다
				count++;
				N -= 5;
			} else {
				count = -1;
				break;
			}
		}
		System.out.println(count);

	}

}
