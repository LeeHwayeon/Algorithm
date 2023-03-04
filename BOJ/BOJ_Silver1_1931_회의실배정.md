# 회의실 배정

날짜: 2023년 3월 4일
레벨: Silver1
분류: 그리디
언어: Java
출제기관: 백준

## 문제

[1931번: 회의실 배정](https://www.acmicpc.net/problem/1931)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 처음 풀이
public class BOJ_Silver1_1931_회의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Room[] rooms = new Room[N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			rooms[i] = new Room(start, end);
		}
		Arrays.sort(rooms); // 정렬
		Stack<Room> stack = new Stack<Room>();
		stack.push(rooms[0]);
		for (int i = 1; i < N; i++) {
			Room now = stack.pop();
			if (now.end > rooms[i].end) { // 종료시간이 작은 것 넣기
				stack.push(rooms[i]);
			} else if (now.end == rooms[i].end) { // 종료 시간 같으면
				if (now.start < rooms[i].start) { // 시작 시간이 작은 것 넣기
					stack.push(now);
				} else {
					stack.push(rooms[i]);
				}
				if (now.end <= rooms[i].start) {
					stack.push(rooms[i]);
				}
			} else { // 종료시간이 크면
				stack.push(now);
				if (now.end <= rooms[i].start) { // 현재 종료시간보다 다음 시작시간이 크거나 같으면
					stack.push(rooms[i]); // 다음 회의 배정 가능
				}
			}
		}
		System.out.println(stack.size());
	}

	static class Room implements Comparable<Room> {
		int start, end;

		public Room(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Room o) {
			if (this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}
}
```

- 시작 시간을 기준으로 오름차순 정렬 후, 시작 시간이 같으면 종료 시간을 기준으로 오름차순 하도록 정렬을 했다 ⇒ 이렇게 하니 많은 if문을 써야해서 가독성이 꽝..
- 더 쉬운 방법이 있을까 하고 다른 풀이를 찾아봤더니 종료시간을 기준으로 정렬한 뒤 직전 종료시간과 다음 시작시간을 비교해주면 완전 간단히 풀리는 풀이를 발견했다
    
    ```jsx
    public class BOJ_Silver1_1931_회의실배정 {
    
    	public static void main(String[] args) throws NumberFormatException, IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		int N = Integer.parseInt(br.readLine());
    		Room[] rooms = new Room[N];
    		StringTokenizer st = null;
    		for (int i = 0; i < N; i++) {
    			st = new StringTokenizer(br.readLine());
    			int start = Integer.parseInt(st.nextToken());
    			int end = Integer.parseInt(st.nextToken());
    			rooms[i] = new Room(start, end);
    		}
    		Arrays.sort(rooms); // 정렬
    
    		int prevEndTime = 0; // 직전 회의 종료 시간
    		int ans = 0;
    		for (int i = 0; i < N; i++) {
    			if (prevEndTime <= rooms[i].start) {
    				prevEndTime = rooms[i].end;
    				ans++;
    			}
    		}
    		System.out.println(ans);
    	}
    
    	static class Room implements Comparable<Room> {
    		int start, end;
    
    		public Room(int start, int end) {
    			super();
    			this.start = start;
    			this.end = end;
    		}
    
    		@Override
    		public int compareTo(Room o) {
    			if (this.end == o.end) {
    				return this.start - o.start;
    			}
    			return this.end - o.end;
    		}
    	}
    }
    ```