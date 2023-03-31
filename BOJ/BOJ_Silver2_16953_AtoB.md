# 제목 없음

날짜: 2023년 3월 31일
레벨: Silver2
분류: BFS/DFS
언어: Java
출제기관: 백준

## 문제

[16953번: A → B](https://www.acmicpc.net/problem/16953)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Silver2_16953_AtoB {
	static long A, B, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		min = Long.MAX_VALUE;

		dfs(A, 0);
		System.out.println(min == Long.MAX_VALUE ? -1 : min);
	}

	static void dfs(long num, long cnt) {
		if (num > B || cnt + 1 > min) {
			return;
		}

		if (num == B) {
			min = Math.min(min, cnt + 1);
		}

		dfs(num * 2, cnt + 1);
		String s = String.valueOf(num) + "1";
		dfs(Long.parseLong(s.trim()), cnt + 1);
	}
}
```

- 간단한 그래프 문제지만 주의해야할 점은 입력의 범위값!
    - 10^9까지 입력이 들어올 수 있기 때문에 곱셈 연산이 있어 모든 숫자들을 `long`으로 선언해줘야 한다.
    - int로 선언했다가 `런타임 에러 (NumberFormat)`가 났다