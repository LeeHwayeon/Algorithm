import java.util.Arrays;
import java.util.Scanner;

/* 처음에 재귀를 돌려서 순열로 풀었으나 시간초과..
 * 다시 문제를 읽어보니 처음에 정렬하고 시작하면 최소가 되는 것을 발견.. */

public class BOJ_11399_ATM {
	static int N, min, sum;
	static int[] P, time;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 사람 수
		min = Integer.MAX_VALUE; // 시간 최솟값
		P = new int[N]; // 인출 시간 배열
		time = new int[N]; // 시간 누적 합 저장할 배열
		sum = 0;

		for (int i = 0; i < N; i++) {
			P[i] = sc.nextInt();
		}

		Arrays.sort(P); // 정렬

		for (int i = 0; i < P.length; i++) {
			for (int j = 0; j <= i; j++) {
				time[i] += P[j]; // 전 사람의 시간을 누적해 배열에 집어넣는다
			}
			sum += time[i];
		}

		min = Math.min(min, sum); // 그 중 최솟값 구하기
		System.out.println(min);

	}

}
