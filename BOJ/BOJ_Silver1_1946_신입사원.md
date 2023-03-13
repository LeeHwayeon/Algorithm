# 신입사원

날짜: 2023년 3월 13일
레벨: Silver1
분류: 그리디
언어: Java
출제기관: 백준

## 문제

[1946번: 신입 사원](https://www.acmicpc.net/problem/1946)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Silver1_1946_신입사원 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine()); // 지원자 수
			Member[] members = new Member[N];

			StringTokenizer st = null;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				members[i] = new Member(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(members); // 서류 순위대로 정렬

			int ans = 1; // 서류 성적 1등 지원자 포함
			int min = members[0].interview; // 서류 성적 1등 지원자의 면접 순위
			for (int i = 1; i < N; i++) {
				if (min > members[i].interview) { // 서류 성적은 떨어지지만 면접 순위는 높은 경우
					min = members[i].interview;
					ans++;
				}
			}
			System.out.println(ans);
		}
	}

	static class Member implements Comparable<Member> {
		int paper, interview;

		public Member(int paper, int interview) {
			super();
			this.paper = paper;
			this.interview = interview;
		}

		@Override
		public int compareTo(Member o) {
			return this.paper - o.paper;
		}
	}
}
```

- 처음에 입력받는 성적의 숫자가 큰 게 순위가 더 높다고 생각해서 문제 이해가 안갔었다..
    
    ⇒ 알고보니 성적이 아니라 순위가 입력으로 주어지는 것 = 숫자가 더 작은게 높은 성적을 가지는 것
    
- 서류 순위를 기준으로 오름차순으로 정렬한 뒤 순위가 제일 높은 지원자의 면접 순위을 기준으로 다음 지원자와의 면접 순위를 비교해서 만약 다음 지원자 면접 순위가 더 높다면(= 숫자가 더 작다면) 면접 순위 최솟값 갱신해주고 ans++
- 문제를 잘 읽자 제발…!!!!
-