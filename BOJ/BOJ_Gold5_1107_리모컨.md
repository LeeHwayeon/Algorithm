# 리모컨

날짜: 2023년 1월 21일
레벨: Gold5
분류: 완전탐색
언어: Java
출제기관: 백준

## 문제

[1107번: 리모컨](https://www.acmicpc.net/problem/1107)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {
	static boolean[] numbers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 이동하려고 하는 채널
		numbers = new boolean[10]; // 숫자 버튼 상태 저장할 배열

		if (N == 100) { // 수빈이는 현재 100번 채널에 있음
			System.out.println(0);
			return;
		}

		int M = Integer.parseInt(br.readLine());
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				numbers[Integer.parseInt(st.nextToken())] = true;
			}
		}

		int min = Math.abs(N - 100); // 모든 버튼이 고장나있을 경우 +,-로만 이동해야함

		// N이 500,000까지니까 6자리 중 가장 큰수 999,999까지 검사
		for (int i = 0; i <= 999999; i++) {
			String num = String.valueOf(i);

			boolean flag = true;
			for (int j = 0; j < num.length(); j++) {
				if (numbers[Integer.parseInt(num.charAt(j) + "")]) {
					flag = false; // 고장난 숫자를 포함하고 있는 경우 break;
					break;
				}
			}

			// 고장난 숫자 포함하고 있지 않고 min보다 작은 경우
			if (flag && min > Math.abs(N - i) + num.length()) {
				min = Math.abs(N - i) + num.length();
			}
		}
		System.out.println(min);
	}
}
```

- 처음에는 N의 각자리마다 고장났는지 확인한 다음 고장났다면 +1, -1 계속 해주면서 차이 적은 수를 누른다고 가정하고 그때 누른 숫자 길이+N과 그 숫자의 차를 출력했다.
    - 그렇게 풀이할 경우
        
        ```
        //입력
        80000
        2
        8 9
        
        //출력
        2228
        ```
        
        이런 경우에는 70000을 누르게 되므로 답이 10005가 되버림
        
        70000을 누르는 것보다 77777을 누르는 것이 차가 더 작음.
        
- 따라서 이건 완전탐색으로 풀어줘야 하는 문제였다…
    - 먼저 min은 현재 100번에 있으니 N-100의 절댓값으로 세팅해준다 ⇒ 모두 고장난 숫자일경우 +,-로만 움직일 수 있기 때문에
    - N이 최대 500,000까지니까 0부터 999,999까지 반복문 수행
        - 고장난 숫자를 포함하고 있는 경우는 바로 넘겨버리기
        - 고장난 숫자를 포함하고 있지 않고, 현재숫자와 N과의 차이에 현재숫자 길이를 더한 수가 더 작을 경우 min 갱신