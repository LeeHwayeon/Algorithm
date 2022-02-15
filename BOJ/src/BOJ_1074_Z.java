import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
	static int N, r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer line = new StringTokenizer(br.readLine());

		N = (int) Math.pow(2, Integer.parseInt(line.nextToken())); // 배열크기
		r = Integer.parseInt(line.nextToken()); // 행
		c = Integer.parseInt(line.nextToken()); // 열

		recursive(r, c, N, 0); // r과 c를 바로 찾는다
	}

	public static void recursive(int i, int j, int N, int count) {

		// 기저조건
		if (N == 1) {
			System.out.println(count);
			return;
		}

		int size = N / 2;
		// 유도파트
		// N을 2로 나눈게 또 하나의 4사분면을 이루기 때문에 N을 2로 나눈것보다 클때는 size를 빼서 반복
		if (i < size && j < size) { // 1번째, count: 넓이를 더하기 위한 변수 1사분면은 0으로시작
			recursive(i, j, size, count);
		} else if (i < size && j >= size) {
			recursive(i, j - size, size, count + size * size * 1); // 2번째, count : 2사분면은 N이 8이라고 할때 4*4*1=16으로 시작
		} else if (i >= size && j < size) {
			recursive(i - size, j, size, count + size * size * 2); // 3번째, count: 3사분면은 4*4*2=32로 시작
		} else {
			recursive(i - size, j - size, size, count + size * size * 3); // 4번째, count : 4사분면은 4*4*3 = 48로 시작
		}
	}

}
