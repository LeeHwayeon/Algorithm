# 접두사찾기

날짜: 2023년 1월 17일
레벨: Silver2
분류: 구현
언어: Java
출제기관: 백준

## 문제

[14426번: 접두사 찾기](https://www.acmicpc.net/problem/14426)

## 내 풀이

```java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14426_접두사찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 비교 문자열 개수 N
		int M = Integer.parseInt(st.nextToken()); // 검사할 문자열 개수 M

		ArrayList<String>[] list = new ArrayList[28];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<String>();
		}
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			list[s.charAt(0) - 'a'].add(s);
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			for (String str : list[s.charAt(0) - 'a']) {
				if (str.contains(s)) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}

}
```

- 첫 글자부터 비교를 하기 때문에 문자열 앞 글자에서 ‘a’를 뺀 값을 인덱스로 써야겠다고 생각해서 리스트를 생성했다.
- 먼저 리스트[비교문자열 앞글자 - ‘a’] 에 비교문자열을 넣어놓고, 검사할 문자열을 입력받으면서 리스트[검사할 문자열 - ‘a’]에 저장되어 있는 문자열과 비교하며 카운트를 셌다
- 문제에서 예시에 있던 cod의 경우 리스트의 ‘c’-’a’인덱스 안에 있는 리스트 문자열 모두의 접두사에 해당해 카운트가 중복되기 때문에 처음 검사할때 맞는거 발견하면 바로 break 처리 해버렸다