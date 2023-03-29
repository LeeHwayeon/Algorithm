# 교환

날짜: 2023년 3월 29일
레벨: Gold3
분류: BFS/DFS, 완전탐색
언어: Java
출제기관: 백준

## 문제

[1039번: 교환](https://www.acmicpc.net/problem/1039)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Gold3_1039_교환 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String N = st.nextToken();// 숫자
		int K = Integer.parseInt(st.nextToken());// 연산 수
		boolean[][] visited = new boolean[K + 1][1000001];

		Queue<String> queue = new LinkedList<>();
		queue.add(N);

		while (!queue.isEmpty() && K > 0) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				String now = queue.poll();

				for (int i = 0; i < N.length() - 1; i++) {
					for (int j = i + 1; j < N.length(); j++) {
						int next = swap(now, i, j);
						// 맨 앞자리가 0이 아니고 현재 수가 지금 turn에서 방문한 적이 없을때
						if (next != -1 && !visited[K][next]) {
							queue.add(String.valueOf(next));
							visited[K][next] = true;
						}
					}
				}

			}
			K--;
		}

		int max = -1;
		for (String s : queue) { // 큐에 있는 것 중 최대값 뽑기
			max = Math.max(max, Integer.parseInt(s));
		}
		System.out.println(max);

	}

	static int swap(String now, int i, int j) {
		char[] arr = now.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

		if (arr[0] == '0') { // 맨 앞이 0이면 안됨
			return -1;
		}

		String newStr = "";
		for (char c : arr) {
			newStr += c + "";
		}
		return Integer.parseInt(newStr);
	}
}
```

- 처음 풀이
    - 우선순위 큐 이용해서 가장 큰 값 순서대로 큐에 담고(만약 값이 같을땐 인덱스 뒤에있는거 순으로)
    - 바꾸면서 제일 첫번째 자리에 0이오는지 계속 확인해주기
    - 큐에서 하나씩 꺼내면서 현재 idx 자리랑 바꾼다… (큐 값이 더 클때)
    
    ⇒ 이러면 숫자 큰 순서대로 정렬된다.
    
    - 그러고도 K 횟수가 남아있으면 맨 뒤 2자리를 번갈아가면서 바꿔줌
    
    ⇒ 이런식으로 생각해서 풀었는데.. 내가 생각지 못한 반례가 있나보다
    
- 맞은 풀이
    - 완탐을 해줘야 하는 문제였다.
    - `queue` : 숫자를 담아줄 큐
    - `visited[][]` : 현재 연산횟수에서 나온 숫자들의 방문처리
    - 큐에 숫자를 집어 넣은 다음
        - 가능한 모든 경우를 swap해주면서 맨 앞자리가 0이 아니고 현재 연산횟수에서 방문한적이 없는 숫자일 경우에만 큐에 다시 넣어준다
    - K가 0이 되면 큐에 담겨있는 것 중 최댓값을 뽑아 출력해준다