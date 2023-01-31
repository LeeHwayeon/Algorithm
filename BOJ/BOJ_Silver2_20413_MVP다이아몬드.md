# MVP 다이아몬드

날짜: 2023년 1월 19일
레벨: Silver2
분류: 그리디
언어: Java
출제기관: 백준

## 문제

[20413번: MVP 다이아몬드 (Easy)](https://www.acmicpc.net/problem/20413)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N개월

		int[] MVP = new int[5];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= 4; i++) {
			MVP[i] = Integer.parseInt(st.nextToken());
		}

		String level = br.readLine(); // 등급표기
		int before = 0; // 지난달 과금액
		int sum = 0; // 지난달+현재달 과금액
		int now = 0; // 현재달 과금액
		int ans = 0; // 누적 과금액
		for (int i = 0; i < level.length(); i++) {
			int index = searchIndex(level.charAt(i));
			if (index == 5) { // 다이아몬드 등급
				ans += MVP[4];
			} else {
				sum = MVP[index] - 1; // 다음 등급 과금액-1이 최대 과금할 수 있는 금액
				now = sum - before; // sum에서 지난달 값 빼면 현재달 최대 과금액
				ans += now; // 현재달 과금액 누적
				before = now;
			}
		}
		System.out.println(ans);
	}

	public static int searchIndex(char c) {
		if (c == 'B') {
			return 1;
		} else if (c == 'S') {
			return 2;
		} else if (c == 'G') {
			return 3;
		} else if (c == 'P') {
			return 4;
		} else {
			return 5;
		}
	}

}
```

- 최대 누적 과금액을 구해야 하기 때문에 순간마다 과금액이 최대이도록 선택하게 함
- 다이아몬드 등급일 경우에는 다이아몬드 등급 기준액 더해주기만 하면 됨