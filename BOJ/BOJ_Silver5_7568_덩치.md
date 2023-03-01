# 덩치

날짜: 2023년 3월 1일
레벨: Silver5
분류: 구현, 완전탐색
언어: Java
출제기관: 백준

## 문제

[7568번: 덩치](https://www.acmicpc.net/problem/7568)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Silver5_7568_덩치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Size[] arr = new Size[N]; // 사람 덩치 저장할 배열
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Size(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int[] result = new int[N]; // 자신보다 큰 덩치의 사람 수
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (arr[i].weight < arr[j].weight && arr[i].height < arr[j].height) {
					cnt++;
				}
			}
			result[i] = cnt + 1;
		}

		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	static class Size {
		int weight, height;

		public Size(int weight, int height) {
			super();
			this.weight = weight;
			this.height = height;
		}
	}

}
```

- N이 최대 50까지니까 N^2으로 해도 시간초과가 나지 않음
- 하나씩 비교하면서 자신보다 큰 덩치 사람 수 세주면 됨