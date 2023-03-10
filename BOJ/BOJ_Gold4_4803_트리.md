# 트리

날짜: 2023년 3월 10일
레벨: Gold4
분류: 유니온파인드, 트리
언어: Java
출제기관: 백준

## 문제

[4803번: 트리](https://www.acmicpc.net/problem/4803)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_Gold4_4803_트리 {
	static int n, m, parent[];
	static boolean noTree[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;
		int index = 1;
		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 정점 개수
			m = Integer.parseInt(st.nextToken()); // 간선 개수
			if (n == 0 && m == 0) {
				break;
			}

			parent = new int[n + 1];
			noTree = new boolean[n + 1];
			setParent();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (!union(a, b)) { // 사이클 생긴 경우
					noTree[parent[a]] = true;
				}
			}

			// 자신의 부모가 최상위 루트로 갱신되지 않은 정점들이 있을 수 있으니 다시 한번 부모 찾기
			for (int i = 1; i <= n; i++) {
				findParent(i);
				// 이미 사이클이 생겼던 부모의 최상위 루트가 바꼈을경우 그 최상위 루트도 사이클 처리해줘야 함
				if (noTree[i]) {
					noTree[parent[i]] = true;
				}
			}

			Set<Integer> set = new HashSet<>();
			for (int i = 1; i <= n; i++) {
				if (!noTree[parent[i]]) { // 사이클 안생긴 루트정점만 담기
					set.add(parent[i]);
				}
			}

			if (set.size() == 0) {
				System.out.println("Case " + index + ": No trees.");
			} else if (set.size() == 1) {
				System.out.println("Case " + index + ": There is one tree.");
			} else {
				System.out.println("Case " + index + ": A forest of " + set.size() + " trees.");
			}
			index++;
		}

	}

	static void setParent() { // 자기 자신으로 부모 세팅
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}

	static int findParent(int num) {
		if (num == parent[num]) {
			return num;
		}
		return parent[num] = findParent(parent[num]);
	}

	static boolean union(int a, int b) {
		int aRoot = findParent(a);
		int bRoot = findParent(b);
		if (aRoot == bRoot) {
			return false;
		}

		parent[bRoot] = aRoot;
		return true;
	}

}
```

- 처음에 예제 입력의 첫번째 테케가 이해가 안가서 질문게시판에서 힌트를 얻었다.
    - 예제 입력의 첫번째 테케는 1-2-3-4 로 연결되어 있는데 답은 3개의 트리가 구성된다는 것
        
        ⇒ 정점이 6개이기 때문에 1~6까지의 정점이 있다
        
        ⇒ (1-2-3-4), 5, 6 이기 때문에 3개의 트리
        
- 8%에서 틀렸습니다가 나와서 질문게시판의 반례를 찾아보니 간선이 입력되면서 갱신된 부모들이 최상위 부모가 아닐 수 있다는 점!
    
    ```java
    4 4
    2 3
    2 4
    3 4
    1 2
    0 0
    ```
    
    - 이렇게 될 경우 유니온 파인드를 끝내면 각 정점의 부모는 [1, 1, 2, 2]로 구성되어 있다
    - 하지만 2 정점의 부모는 1이기 때문에 최종적으로 [1, 1, 1, 1]의 형태가 나와야 하는 것
    - 따라서 정점을 다시 돌면서 최종 루트 부모를 찾아주는 것을 한 번 더 수행해서 해결했다

### 해결 방법

- `parent` : 정점의 부모 기록
- `noTree` : 사이클이 생긴 루트 정점 기록
1. 부모 자기 자신으로 세팅
2. 간선 입력받으면서 사이클이 생기는 지 확인
    - 만약 두 정점 사이에 사이클이 생겼다면 두 정점의 부모를 인덱스로 가진 `noTree` 배열에 true처리
3. 간선을 다 돌았음에도 자신의 부모가 최상위 루트로 갱신이 안 된 정점이 존재할 수 있으니 다시 한 번 부모를 찾아주는 작업을 수행
    - 만약에 2번 수행하면서 true처리가 됐던 정점이라면 그 정점의 최상위 루트가 갱신됐을 수도 있으니 다시 한 번 그 정점의 부모를 인덱스로 가진 `noTree` 배열에 true처리를 해준다
4. `사이클 안생긴 정점 = !noTree[parent[i]]` 일경우 `set`에 담아준다
    - 중복 제거를 위해 `set`을 이용함
5. set의 사이즈에 맞게 출력해준다.