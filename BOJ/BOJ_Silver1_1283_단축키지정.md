# 단축키 지정

날짜: 2023년 3월 8일
레벨: Silver1
분류: 문자열
언어: Java
출제기관: 백준

## 문제

[1283번: 단축키 지정](https://www.acmicpc.net/problem/1283)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Silver1_1283_단축키지정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] alphabet = new boolean[26]; // 단축키 지정되어 있는지 처리할 배열
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			// 단어의 첫글자가 이미 단축키로 지정되었는지 살펴보기
			char c = s.toUpperCase().charAt(0);
			if (!alphabet[c - 'A']) {
				alphabet[c - 'A'] = true;
				sb.append("[" + s.charAt(0) + "]");
				if (s.length() > 1) {
					sb.append(s.substring(1) + "\n");
				} else {
					sb.append("\n");
				}
				continue;
			}
			// 다른 단어 있는지 찾고
			boolean flag = false;
			for (int j = 1; j < s.length(); j++) {
				char other = s.toUpperCase().charAt(j);
				if (other == ' ') { // 공백 발견하면 그 다음이 단어 시작
					other = s.toUpperCase().charAt(j + 1);
					if (!alphabet[other - 'A']) {
						alphabet[other - 'A'] = true;
						sb.append(s.substring(0, j + 1) + "[" + s.charAt(j + 1) + "]");
						if (j + 2 < s.length()) {
							sb.append(s.substring(j + 2) + "\n");
						} else {
							sb.append("\n");
						}
						flag = true;
						break;
					}
				}
			}
			// 모든 단어의 첫글자 이미 지정
			if (!flag) {
				boolean no = false;
				for (int j = 0; j < s.length(); j++) {
					char other = s.toUpperCase().charAt(j);
					if (other != ' ' && !alphabet[other - 'A']) {
						alphabet[other - 'A'] = true;
						sb.append(s.substring(0, j) + "[" + s.charAt(j) + "]");
						if (j + 1 < s.length()) {
							sb.append(s.substring(j + 1) + "\n");
						} else {
							sb.append("\n");
						}
						no = true;
						break;
					}
				}
				// 어떠한 것도 단축키 지정 불가
				if (!no) {
					sb.append(s + "\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

}
```

- 문제의 조건대로 수행하면 되는 문제
- 주의할 점은 문자열을 이어 붙일때 `인덱스 값을 체크`해야한다는 점, 그리고 모든 단어의 첫글자가 이미 지정되어 있는 경우 왼쪽부터 단축키 지정안된 알파벳 체크할때 조건에 `공백이 아닌것 && 방문안한것` 순으로 해줘야 문제가 풀린다