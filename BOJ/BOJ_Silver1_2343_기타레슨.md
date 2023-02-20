# 기타레슨

날짜: 2023년 2월 20일
레벨: Silver1
분류: 이분탐색
언어: Java
출제기관: 백준

## 문제

[2343번: 기타 레슨](https://www.acmicpc.net/problem/2343)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Silver1_2343_기타레슨 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] bluelay = new int[N];
		int low = 0; // 녹화길이 최소
		int high = 0; // 녹화길이 최대
		for (int i = 0; i < N; i++) {
			bluelay[i] = Integer.parseInt(st.nextToken());
			high += bluelay[i]; // 들어오는 값 모두 더해서 녹화길이 최댓값
			low = Math.max(low, bluelay[i]); // 들어오는 값 중 최댓값을 녹화길이의 최솟값으로 정한다
		}

		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;

			int cnt = 0; // mid보다 작은 블루레이의 개수
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (sum + bluelay[i] > mid) { // 만약 mid보다 크면 더이상 더할 수 없음
					sum = 0; // 0으로 초기화
					cnt++; // 블루레이 개수 올려주기
				}
				sum += bluelay[i];
			}
			if (sum > 0) { // 반복문 끝났는데 sum 값이 0보다 크다면 나눠진 영역이 하나더 존재하는 것
				cnt++;
			}

			if (cnt <= M) {
				high = mid - 1;
			} else if (cnt > M) {
				low = mid + 1;
			}
		}
		System.out.println(low);
	}

}
```

- 이분탐색을 응용한 매개변수 탐색 문제라고 함
- `low(녹화길이 최소)`, `mid`, `high(녹화길이 최대)` 가 인덱스가 아닌 녹화길이로 생각하고 문제를 풀어야 한다
    - 초기값 설정
        - `low` : 입력값 중 최대
        - `high` : 입력값을 모두 더한 값
    - 반복문에서 주의할 점은 안에 for문을 모두 돌았을 경우에도 sum값이 0보다 크다면 나눠진 영역이 하나더 존재한다는 뜻이기 때문에 cnt를 증가시켜줘야한다.
        - 예를 들어, [1,2,3,4,5,6,7,8,9], low=9, mid=27, high=45일때
            - 첫번째로 cnt가 증가하는 경우에는  6까지 더했을 경우
            - 6이후에 7+8+9를해도 27을 넘지 않기 때문에 cnt는 증가하지 않는다
            - 하지만 결국 나눠진 영역은 1~6, 7~9로 두영역이기때문에 cnt를 올려줘야함