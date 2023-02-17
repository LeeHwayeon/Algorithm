import java.util.Scanner;

public class BOJ_1592_영식이와친구들 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 사람 수
		int M = sc.nextInt(); // 한 사람이 공을 M번 받았을 때 게임 끝
		int L = sc.nextInt(); // L번째 있는 사람에게 공 던짐

		int[] count = new int[N]; // 각자 공을 몇번 받았는지 기록할 배열

		int ans = 0;
		int idx = 0;
		count[idx]++; // 처음에 공 받는 사람은 1번
		while (true) {
			if (count[idx] < M && count[idx] % 2 != 0) { // 공 받은 횟수가 M보다 적고 현재 공을 받은 횟수가 홀수번
				if (idx + L < N) {
					idx += L;
				} else { // 오른쪽으로 L번 이동했는데 N보다 커지면
					idx = (idx + L) - N;
				}
				count[idx]++;
				ans++;
			} else if (count[idx] < M && count[idx] % 2 == 0) { // 공 받은 횟수가 M보다 적고 현재 공을 받은 횟수가 짝수번
				if (idx - L < 0) { // 왼쪽으로 L번 이동했는데 0보다 작아지면
					idx = N + (idx - L);
				} else {
					idx -= L;
				}
				count[idx]++;
				ans++;
			} else if (count[idx] == M) {
				break;
			}
		}
		System.out.println(ans);

	}
}
