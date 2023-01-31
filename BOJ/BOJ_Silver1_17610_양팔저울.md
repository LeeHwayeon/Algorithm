# 양팔저울

날짜: 2023년 1월 26일
레벨: Silver1
분류: BFS/DFS
언어: Java
출제기관: 백준

## 문제

[17610번: 양팔저울](https://www.acmicpc.net/problem/17610)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17610_양팔저울 {
	static int k, g[], sum;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine()); // 추 개수
		g = new int[k];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			g[i] = Integer.parseInt(st.nextToken());
			sum += g[i];
		}

		visited = new boolean[sum + 1];
		dfs(0, 0);
		int cnt = 0;
		for (int i = 1; i <= sum; i++) {
			if (!visited[i])
				cnt++;
		}
		System.out.println(cnt);
	}

	static void dfs(int cnt, int sum) {
		if (cnt == k) {
			if (sum > 0)
				visited[sum] = true;
			return;
		}

		dfs(cnt + 1, sum);
		dfs(cnt + 1, sum + g[cnt]);
		dfs(cnt + 1, sum - g[cnt]);
	}

}
```

- 추가 {1, 2, 6} 일경우
- 각 추들을 그대로 사용하거나 더해서 사용해서 만들어지는 물의 무게의 경우 `1,2,3,6,7,8,9` 이다
- 추 + 물의 무게와 또 다른 추를 양팔 저울에 올려놓아 만들어지는 경우는 `4,5`이다
    - 이 경우는 반대로 생각하면 물의 `무게 = 추 - 추` 로 만들어진다는 소리
- 최종적으로 현재 추를 선택하지 않거나, 추를 더해주거나, 빼서 만들 수 있는 모든 합을 구하면 됨