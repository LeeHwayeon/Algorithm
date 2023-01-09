# 11000_강의실배정

날짜: 2023년 1월 9일
레벨: Gold
분류: 우선순위큐
상세레벨: Gold5

[11000번: 강의실 배정](https://www.acmicpc.net/problem/11000)

### 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000_강의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Class[] c = new Class[N]; // 강의 담을 배열
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			c[i] = new Class(s, t);
		}
		Arrays.sort(c);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(c[0].t); // 첫번째 강의의 종료 시간
		for (int i = 1; i < N; i++) { // 첫번째 강의 이미 넣었으니 1부터 시작
			if (pq.peek() <= c[i].s) { // 현재 큐에 들어가 있는 종료시간이 다음 강의 시작시간보다 작거나 같을경우
				pq.poll();
			}
			pq.add(c[i].t);
		}
		System.out.println(pq.size());
	}

	static class Class implements Comparable<Class> {
		int s, t;

		public Class(int s, int t) {
			super();
			this.s = s;
			this.t = t;
		}

		@Override
		public int compareTo(Class o) {
			if (this.s - o.s == 0) {
				return this.t - o.t;
			}
			return this.s - o.s;
		}
	}
}
```

- 큐에서 나온 종료시간과 다음 수업 시작시간 비교 후 남은 큐의 사이즈가 정답
- 처음에 강의실 수가 아니라 이어지는 수?를 세서 틀림.. 문제를 잘 읽자^^
- Class 클래스 만들때 비교 메소드 구현해놓고 정렬안해줘서 한번 더 틀림.. 정신차리자^^