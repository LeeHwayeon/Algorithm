# 0 만들기

날짜: 2023년 2월 17일
레벨: Gold5
분류: BFS/DFS, 완전탐색
언어: Java
출제기관: 백준

## 문제

[7490번: 0 만들기](https://www.acmicpc.net/problem/7490)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Gold5_7490_0만들기 {
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			dfs(2, 1, 1, -2, String.valueOf(1));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	// num : 현재 수, sum : 현재까지 더한값, before : 바로 전 수, sign : 바로 전에 삽입한 부호
	// sign은 -1(-), 1(+), 0(공백)
	static void dfs(int num, int sum, int before, int sign, String s) {
		if (num == N + 1) { // 마지막 수까지 다 고려했을 경우
			if (sum == 0) {
				sb.append(s + "\n");
			}
			return;
		}

		String str = String.valueOf(num);
		// 공백을 삽입할 경우
		int newNum = Integer.parseInt(String.valueOf(before) + str); // 바로 전수와 현재수를 이어붙인다
		int newSum = sum; // 새로운 sum값
		if (sign == 1) { // 바로 전에 삽입한 부호가 +일경우 전 수를 빼준다음 newNum을 더해줌
			newSum = sum - before + newNum;
		} else if (sign == -1) { // 바로 전에 삽입한 부호가 -일경우 전 수를 더해준다음 newNum 빼줌
			newSum = sum + before - newNum;
		} else { // 바로 전에 공백을 삽입했을 경우 newSum을 newNum으로 갱신
			newSum = newNum;
		}
		// ASCII 순서는 공백 -> + -> - 임
		dfs(num + 1, newSum, newNum, 0, s + " " + str); // 공백
		dfs(num + 1, sum + num, num, 1, s + "+" + str); // +
		dfs(num + 1, sum - num, num, -1, s + "-" + str); // -
	}

}
```

- N이 9까지니까 부호가 3개여도 최대 3^9이고 테케 또한 9까지니 3^9*9이므로 시간초과가 안날것임..
- **DFS를 이용해서 공백, +, -를 붙이는 모든 경우 탐색**
    - DFS 순서는 ASCII 순서를 따라 `공백 → + → -` 순으로 해줄 것
    - `num(현재 수)`, `sum(현재까지 더한값)`, `before(바로 전 수)`, `sign(바로 전 부호)`, `s(현재까지 이어붙인 문자열)`
    - +, -의 경우 `sum`에 현재값을 더하고 빼주면서 그대로 DFS 수행하면 됨
    - 공백의 경우
        - `newNum` : 바로 전 수와 현재수를 이어붙이기
        - `newSum` : sum 계산 다시 해주기
            - 바로 전 삽입 부호가 `+`일 경우 `newSum = sum - before + newNum`
            - 바로 전 삽입 부호가 `-`일 경우 `newSum = sum + before - newNum`
            - 바로 전 삽입 부호가 `공백`일 경우 `newSum = newNum`
        - 위의 계산된 newNum, newSum으로 DFS 돌리기