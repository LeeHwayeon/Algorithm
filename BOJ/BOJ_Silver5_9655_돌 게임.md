# 돌 게임

날짜: 2023년 2월 6일
레벨: Silver5
분류: DP
언어: Java
출제기관: 백준

## 문제

[9655번: 돌 게임](https://www.acmicpc.net/problem/9655)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9655_돌게임 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(N % 2 == 0 ? "CY" : "SK");
	}

}
```

- DP 문제였지만,, N이 1부터 5까지 계산을 해봤더니 무조건 짝수일경우에는 상근이가 이기고 홀수일경우에는 창영이가 이기는 규칙을 갖고 있어서 그대로 출력했더니 정답..!