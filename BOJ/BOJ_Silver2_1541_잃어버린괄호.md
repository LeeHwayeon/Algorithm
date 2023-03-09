# 잃어버린 괄호

날짜: 2023년 3월 9일
레벨: Silver2
분류: 그리디
언어: Java
출제기관: 백준

## 문제

[1541번: 잃어버린 괄호](https://www.acmicpc.net/problem/1541)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Silver2_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("-"); // 뺄셈으로 분리

		int ans = 0;
		for (int i = 0; i < str.length; i++) {
			String[] divide = str[i].split("\\+"); // 덧셈으로 분리
			int sum = 0;
			for (int j = 0; j < divide.length; j++) {
				sum += Integer.parseInt(divide[j]);
			}

			if (i == 0) {
				ans = sum;
			} else {
				ans -= sum;
			}
		}
		System.out.println(ans);
	}
}
```

- 최솟값을 만들기 위해서는 뺄셈을 기준으로 생각해야 한다 ⇒ 덧셈을 모두 먼저 더해준뒤 빼줘야 함
- 뺄셈을 기준으로 나눈다음 덧셈 부분을 계산하고 첫번째 숫자가 아닐경우 다 빼주면 된다
- 주의해야 할 점은 split의 경우 정규식(regex)을 받기 때문에 "+"을 하면 regex.PatternSyntaxException을 뱉는다.
    - 문자가 메타문자(meta character)라 그렇다.(=특별한 의미를 담고 있다는 뜻)
    - 그렇기 때문에 온전하게 문자 그 자체로 이용하기 위해서는 이스케이프 처리를 해야한다. 하지만 \(백슬래시)도 단독으로 출력할 수 없기 때문에 백슬래시 자체도 이스케이프 해야한다. 즉 \\+ 를 해야 우리가 분리하고자 하는 "+" 문자 그대로 분리할 수 있다.