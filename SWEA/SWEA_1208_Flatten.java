import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1208_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 0; // 테케
		while (T < 10) {
			T++;
			int D = Integer.parseInt(br.readLine()); // 덤프횟수
			int[] arr = new int[100]; // 상자를 담을 가로 길이 100인 배열

			StringTokenizer line = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(line.nextToken());
			}

			int max = 0, min = 100; // 최댓값, 최솟값
			int maxIdx = 0, minIdx = 0; // 최댓값과 최솟값을 저장할 인덱스 변수
			while (D >= 0) {
				for (int i = 0; i < arr.length; i++) {
					if (max < arr[i]) {
						max = arr[i];
						maxIdx = i;
					}
					if (min > arr[i]) {
						min = arr[i];
						minIdx = i;
					}
				}
				// 평탄화
				if (D > 0) {
					arr[maxIdx]--;
					arr[minIdx]++;

				}
				D--;

				max = 0;
				min = 100;

				// 높이 차가 0이나 1이되면 평탄화가 완료 된 것
				if ((arr[maxIdx] - arr[minIdx]) == 0 || (arr[maxIdx] - arr[minIdx]) == 1) {
					break;
				}
			}
			System.out.println("#" + T + " " + (arr[maxIdx] - arr[minIdx]));
		}
	}

}
