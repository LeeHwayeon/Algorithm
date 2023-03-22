# 밑줄

날짜: 2023년 3월 22일
레벨: Silver1
언어: Java
출제기관: 백준

## 문제

[1474번: 밑 줄](https://www.acmicpc.net/problem/1474)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Silver1_1474_밑줄 {
	static int N, M, len, mok, remain;
	static String underline, str[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		str = new String[N];
		underline = "_";

		len = 0; // 총 길이
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
			len += str[i].length();
		}

		mok = (M - len) / (N - 1); // 몫
		remain = (M - len) % (N - 1); // 나머지

		// 소문자에 밑 줄 붙이기
		for (int i = 1; i < N; i++) {
			if ('a' <= str[i].charAt(0) && str[i].charAt(0) <= 'z' && remain > 0) {
				str[i] = "_" + str[i];
				remain--;
			}
		}

		// 뒤에 위치한 대문자에 먼저 나머지만큼 밑줄 이어붙이기
		for (int i = N - 1; i > 0; i--) {
			if ('A' <= str[i].charAt(0) && str[i].charAt(0) <= 'Z' && remain > 0) {
				str[i] = "_" + str[i];
				remain--;
			}
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < mok; j++) {
				str[i] = "_" + str[i];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			sb.append(str[i]);
		}
		System.out.println(sb.toString());
	}
}
```

- 사전 순은 소문자 > 밑줄 > 대문자
- 총 길이를 N-1로 나눈 나머지가 0보다 크다면 `소문자 → 뒤에서부터 대문자` 순으로 밑줄을 더 추가해줘야 한다.
    - 사전 순으로 가장 앞서는 단어를 출력해줘야 하기 때문에