# 달력

날짜: 2023년 2월 27일
레벨: Silver1
분류: 구현
언어: Java
출제기관: 백준

## 문제

[20207번: 달력](https://www.acmicpc.net/problem/20207)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Silver1_20207_달력 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 일정 개수
		int[] cnt = new int[366];
		int maxDay = 0; // 입력중 가장 큰 날짜

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for (int j = s; j <= e; j++) { // 일정 있는 날짜 카운트 올리기
				cnt[j]++;
			}
			maxDay = Math.max(maxDay, e);
		}

		int width = 0; // 일정 가로 길이
		int maxHeigth = 0; // 가장 많이 겹치는 날의 개수
		int sum = 0;
		for (int i = 1; i <= maxDay; i++) {
			if (cnt[i] == 0) {
				sum += width * maxHeigth;
				width = 0;
				maxHeigth = 0;
				continue;
			}
			width++;
			maxHeigth = Math.max(maxHeigth, cnt[i]);
		}
		sum += width * maxHeigth;
		System.out.println(sum);
	}

}
```

- 처음에는 스케쥴 클래스 만들어서 PQ에 담고 2차원 배열에 채워서 넓이를 구하려고 했음
- 더 간단한 방법이 있었다
    - 어차피 구해야하는 건 `일정이 연속된 날짜의 길이`, `겹치는 날짜의 최대 크기`
    - 따라서 입력을 받을때 해당 날짜의 카운트를 올린 다음 처음부터 0인 구간을 기준으로 그룹을 나눠서 넓이를 구해주면 된다.