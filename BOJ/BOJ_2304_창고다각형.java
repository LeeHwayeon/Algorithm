import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2304_창고다각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int result = 0; // 면적
		int N = Integer.parseInt(br.readLine()); // 기둥 개수
		int[] array = new int[1001]; // 기둥을 저장할 배열(처음에 1000으로 설정해서 어레이에러남..)
		int max = -1; // 최대값 변수
		int maxIdx = -1; // 최대값 인덱스 변수
		int max2 = -1;
		int maxIdx2 = -1;

		for (int n = 0; n < N; n++) {
			StringTokenizer line = new StringTokenizer(br.readLine());

			int L = Integer.parseInt(line.nextToken());
			int H = Integer.parseInt(line.nextToken());

			array[L] = H;

			if (max < array[L]) { // 최대값
				max = array[L];
				maxIdx = L;
				max2 = array[L];
				maxIdx2 = L;
			} else if (max == array[L]) { // 최대값이 두개일때..?
				max2 = array[L];
				maxIdx2 = L;
			}

		}

//		System.out.println("max:" + max + " maxIdx:" + maxIdx);
//		System.out.println("max2:" + max2 + " maxIdx2:" + maxIdx2);

		int current = 0;
		int currentIdx = 0;

		// 최대값보다 작을때 : 앞에서 시작
		for (int i = 0; i <= maxIdx; i++) {
			if (array[i] != 0) {
				if (current <= array[i]) { //같을때를 체크 안해서 계속 틀렸다..
//					System.out.println("current :"+current+" currentIdx:"+currentIdx+" array[i]:"+array[i]+" i:"+i);
					result += (i - currentIdx) * current;
//					System.out.println(result);
					current = array[i];
					currentIdx = i;
				}
			}
		}
		
		current = 0;
		currentIdx = 999;
		
		// 최대값보다 클때 : 뒤에서 시작
		for (int i = array.length-1; i >= maxIdx2; i--) {
			if (array[i] != 0) {
				if (current <= array[i]) {
//					System.out.println("current :"+current+" array[i]:"+array[i]+" i:"+i);
					result += (currentIdx - i) * current;
					current = array[i];
					currentIdx = i;
				}
			}
		}

		if (maxIdx == maxIdx2) { // 최대값 하나일때
			System.out.println(result + max); // 최대값부분을 빼고 계산했기 때문에 마지막에 더해줌
//			System.out.println("최대값 하나");
		} else { // 최대값 두개일때
			System.out.println(result + (maxIdx2 - maxIdx + 1) * max);
//			System.out.println("최대값 둘");
		}

	}

}