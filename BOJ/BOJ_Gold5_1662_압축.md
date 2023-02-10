# 압축

날짜: 2023년 2월 10일
레벨: Gold5
분류: 문자열
언어: Java
출제기관: 백준

## 문제

[1662번: 압축](https://www.acmicpc.net/problem/1662)

## 내 풀이

```java
import java.util.*;
import java.io.*;

public class BOJ_Gold5_1662_압축 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();

		Stack<Integer> stack = new Stack<Integer>(); // 길이를 저장할 스택
		for (int i = 0; i < S.length(); i++) {
			String now = S.charAt(i) + "";
			if (now.equals("(")) { // 여는괄호는 -1로 넣어주자
				stack.push(-1);
			} else if (now.equals(")")) {
				// 닫는괄호를 만났으니 여는괄호를 찾아보자
				int index = 0; // 여는괄호 만나기 전까지 길이
				while (true) {
					int before = stack.pop();
					if (before != -1) { // 여는괄호 아닐경우 길이 증가
						index += before;
					} else {
						break;
					}
				}
				int k = stack.pop(); // 반복할 숫자 k
				stack.push(k * index); // k랑 여는괄호 만나기 전까지 길이 곱해서 스택에 넣기
			} else if (i < S.length() - 1 && S.charAt(i + 1) == '(') { // 숫자 + (
				stack.push(Integer.parseInt(now)); // 다음이 여는 괄호면 K번 반복이니 그 숫자 그대로 넣어줌
			} else { // 숫자 + 숫자
				stack.push(1);
			}

		}

		int ans = 0;
		while (!stack.isEmpty()) {
			ans += stack.pop(); // 길이 더하기
		}
		System.out.println(ans);
	}
}
```

- 문자열 문제라서 스택을 이용해서 풀어야겠다고 했고 처음에 풀때는 뒤에서부터 인덱스계산하면서 풀었는데 모든 테케에 맞지 않는 오답이었다
- 올바른 해결 방법
    1. `(` 일경우에는 stack을 Integer로 만들었기때문에 `-1` push
    2. `숫자 + (` 일경우에는 숫자가 k번 반복해야하는 숫자이므로 그대로 push
    3. `숫자 + 숫자` 일경우에는 길이는 1이니 `1` push
    4. `)` 일경우에는 `(` 를 찾자
        1. `-1 = (` 만나기 전까지 `index`에 현재 꺼낸 값 더해주기
        2. `-1` 만났을 때 stack에서 `k`를 꺼내서 `index`와 곱한 값을 다시 stack에 넣는다
    
    ⇒ 스택 돌면서 더해주면 압축 전 문자열 길이