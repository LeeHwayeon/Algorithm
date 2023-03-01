# 방 번호

날짜: 2023년 3월 1일
레벨: Silver5
분류: 구현
언어: Java
출제기관: 백준

## 문제

[1475번: 방 번호](https://www.acmicpc.net/problem/1475)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Silver5_1475_방번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int[] number = new int[9]; // 0~8

		for (int i = 0; i < N.length(); i++) {
			if (N.charAt(i) == '9' || N.charAt(i) == '6') { // 6 or 9는 뒤집어서 이용할 수 있으므로
				number[6]++; // 6에만 카운트를 올려준다
			} else {
				number[N.charAt(i) - '0']++; // 해당 자리수에 맞는 인덱스 값 증가
			}
		}

		int max = 0; // 필요한 세트 개수
		for (int i = 0; i < number.length; i++) {
			if (i == 6) {
				max = (int) Math.max(max, Math.round((double) number[i] / 2));
			} else {
				max = Math.max(max, number[i]);
			}
		}
		System.out.println(max);
	}

}
```

- 6과 9는 뒤집어서 이용할 수 있기 때문에 9도 6자리에 카운트를 올려준 다음 `number` 배열을 돌면서 `i`가 `6`일 경우에는 `number[i]/2`를 반올림 한 값과 max를 비교해서 필요한 세트 개수의 최솟값을 구한다