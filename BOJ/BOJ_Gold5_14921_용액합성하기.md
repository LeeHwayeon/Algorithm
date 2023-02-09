# 용액 합성하기

날짜: 2023년 2월 9일
레벨: Gold5
분류: 투포인터
언어: Java
출제기관: 백준

## 문제

[14921번: 용액 합성하기](https://www.acmicpc.net/problem/14921)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Gold5_14921_용액합성하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = N - 1;
		int min = 100000000; //두 용액의 합의 절댓값
		int ans = 0; //두 용액 섞은 합
		while (start != end) {
			int sum = A[start] + A[end];
			if (sum < 0) { //만약 음수가 나올경우 start + 1
				start++;
			} else { // 양수일경우 end -1
				end--;
			}
			if (min > Math.abs(sum)) { //합의 절댓값이 min보다 작을때, min과 ans 갱신
				min = Math.abs(sum);
				ans = sum;
			}
		}
		System.out.println(ans);
	}

}
```

- 문제를 보니 두 용액을 혼합해서 0에 가까운 용액을 구해야 하고, 용액들이 오름차순으로 정렬되어 있길래 바로 투포인터를 이용해서 풀면 되겠다고 생각했다