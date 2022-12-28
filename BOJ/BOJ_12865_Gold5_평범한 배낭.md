# 12865_평범한 배낭

날짜: 2022년 12월 28일
레벨: Gold
분류: DP
상세레벨: Gold5

[12865번: 평범한 배낭](https://www.acmicpc.net/problem/12865)

- 우선순위 큐를 이용해서 풀면 되는 줄 알고 그렇게 풀었으나…
- 전형적인 DP 문제라고 한다. 덕분에 다시 DP 개념 공부함

### 내 풀이

```jsx
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N + 1][K + 1];
		int[] W = new int[N + 1]; // 무게
		int[] V = new int[N + 1]; // 가치

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = dp[i - 1][j]; // 기본적으로 전 값을 대입
				if (j - W[i] >= 0) { // 현재 무게에서 자신의 무게를 뻈을 때 0 이상이면
					// 전 값과 남은 무게 가치 + 자신 가치 중 큰 것 대입
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}

}
```

- 1번 아이템 부터 n번 아이템까지 담을 수 있는지 없는지 확인
    - 1번 `(6,13)`
       <div><img width="50%" src="https://user-images.githubusercontent.com/33210124/209809504-55d83911-266e-477e-860e-e644e5de7362.jpeg"></div>
        
        - 무게가 6이기 때문에 1~5일때는 담을 수 없음
    - 2번 `(4,8)`
       <div><img width="50%" src="https://user-images.githubusercontent.com/33210124/209809767-3edad984-ff73-453c-a5f3-6ee9ceeaa8cf.jpeg"></div>
        
        - 초기 값은 이전 아이템이 각 무게마다 담은 가치가 저장될 것
        - 무게가 4이기 때문에 1~3일때는 담을 수  없음
        - 4부터 Math.max(이전 아이템 or 이전 아이템의 현재무게-내무게 가치 + 현재 내 가치) 비교
    - 3번 `(3,6)`
       <div><img width="50%" src="https://user-images.githubusercontent.com/33210124/209809774-883d6cc5-17ee-40ba-9d71-291b3f96a854.jpeg"></div>
        
    - 4번 `(5,12)`
       <div><img width="50%" src="https://user-images.githubusercontent.com/33210124/209809780-c4017659-394f-4365-b093-42c41dfb5fd2.jpeg"></div>
