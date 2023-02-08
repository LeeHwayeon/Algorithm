# 수 이어 쓰기

날짜: 2023년 2월 8일

## 문제

[1515번: 수 이어 쓰기](https://www.acmicpc.net/problem/1515)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Silver3_1515_수이어쓰기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int index = 0; // 입력 문자열 s와 비교하면서.. 채울..

		// 최솟값을 1부터 30000까지 1씩 늘려가며 비교하기
		for (int min = 1; min <= 30000; min++) {
			String tmp = String.valueOf(min);
			// 현재 최솟값 각 자리 숫자와 비교할 문자열 s의 index번째 숫자를 비교
			for (int i = 0; i < tmp.length(); i++) {
				// 비교할 문자열 s의 index번째 숫자가 현재 최솟값 i번째와 같을 경우
				if (tmp.charAt(i) == s.charAt(index)) {
					index++;
				}
				if (index == s.length()) {
					System.out.println(min);
					return;
				}
			}
		}
	}

}
```

- 처음에 나는 비교할 문자열 앞에 붙일 변수를 따로 생성한 뒤 그걸 붙여가면서 비교해주고(?) 다음 숫자가 클때는 +1해주면서 비교해야 하나 싶었는데 자리 수 늘어갈 수록 그 로직이 안 맞았음…
- [블로그 설명](https://nahwasa.com/entry/%EB%B0%B1%EC%A4%80-1515-%EC%9E%90%EB%B0%94-%EC%88%98-%EC%9D%B4%EC%96%B4-%EC%93%B0%EA%B8%B0-BOJ-1515-JAVA)을 참고해서 풀이했다..