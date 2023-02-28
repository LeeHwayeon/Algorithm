# 트럭

날짜: 2023년 2월 28일
레벨: Silver1
분류: 구현
언어: Java
출제기관: 백준

## 문제

[13335번: 트럭](https://www.acmicpc.net/problem/13335)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Silver1_13335_트럭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 트럭 수
		int w = Integer.parseInt(st.nextToken()); // 다리 길이
		int L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중

		Queue<Integer> truck = new LinkedList<>(); // 트럭 담을 큐
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			truck.add(Integer.parseInt(st.nextToken()));
		}

		Queue<Integer> bridge = new LinkedList<>(); // 다리 위 상태 담을 큐
		for (int i = 0; i < w; i++) { // 처음엔 다리에 아무것도 올라가 있지 않으니 0 삽입
			bridge.add(0);
		}

		int time = 0;
		int sum = 0;
		while (!truck.isEmpty()) {
			int now = bridge.poll(); // 다리 위에 있는 맨 앞의 값 빼기
			sum -= now;
			time++;
			if (truck.peek() + sum <= L) { // 트럭이 다리 위로 올라갈 수 있음
				int next = truck.poll();
				sum += next;
				bridge.add(next);
			} else {
				bridge.add(0); // 올라갈 수 없으면 0
			}
		}
		// 트럭이 다리위로 다 올라간 시간과 다리 길이를 합하면 최종 걸리는 시간
		System.out.println(time + w);
	}

}
```

- 문제를 이해하는 게 어려웠던 문제,,
- 하나의 단위시간에 하나의 단위길이 만큼 이동 가능하다 = 1시간에 1 이동가능
- 다리 위의 상태를 저장할 큐, 입력된 트럭 무게를 저장할 큐 두개를 이용해서 문제를 풀이하면 된다
    - 트럭 큐가 다 빌때까지 다리 위에 트럭을 올릴 수 있는지 없는지를 체크해주면 됨
- 마지막 출력은 더이상 들어갈 트럭이 없을때까지 반복문을 돌았기 때문에 마지막 트럭은 이제 막 다리 위에 올라간 상태, 따라서 다리 길이만큼 더해주면 최종 걸리는 시간을 출력할 수 있다