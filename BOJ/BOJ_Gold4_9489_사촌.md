# 사촌

날짜: 2023년 3월 24일
레벨: Gold4
분류: 트리
언어: Java
출제기관: 백준

## 문제

[9489번: 사촌](https://www.acmicpc.net/problem/9489)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Gold4_9489_사촌 {
	static int n, k, arr[], idx, searchIdx;
	static Node[] node;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 노드 개수
			k = Integer.parseInt(st.nextToken()); // 사촌의 수 구해야할 노드
			arr = new int[n];
			node = new Node[n];
			idx = 0; // 부모가 누군지 기록할 인덱스
			searchIdx = 0; // 사촌의 수 구해야할 노드의 인덱스

			if (n == 0 && k == 0)
				break;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (arr[i] == k) {
					searchIdx = i;
				}
			}

			node[0] = new Node(arr[idx], 1, idx); // 루트 노드는 자기 자신이 부모이며, depth는 1
			for (int i = 1; i < n; i++) {
				node[i] = new Node(arr[idx], node[idx].d + 1, idx);
				if (i != n - 1 && arr[i] + 1 != arr[i + 1]) {
					idx++;
				}
			}
			int ans = 0;
			for (Node n : node) {
				// 사촌의 수 구해야할 노드의 부모가 다르고, depth가 같은 경우가 사촌임
				// 부모의 부모도 같은지 확인해줘야 사촌인지 판별가능
				if (node[searchIdx].d == n.d && node[searchIdx].p != n.p
						&& node[node[searchIdx].idx].p == node[n.idx].p) {
					ans++;
				}
			}
			System.out.println(ans);
		}
	}

	static class Node {
		int p, d, idx;

		public Node(int p, int d, int idx) {
			super();
			this.p = p;
			this.d = d;
			this.idx = idx;
		}
	}
}
```

- `arr[]` : 노드 기록할 배열
- `node[]` : 각 노드의 부모, depth, 해당 노드의 arr[]배열에서의 인덱스 기록할 배열
- `idx` : 부모가 누군지 기록할 인덱스
- `searchIdx` : 사촌의 수 구해야할 노드의 인덱스
- 아이디어가 중요했던 문제.. 스터디 후 팀원의 아이디어를 듣고 다시 풀어봤다
- 풀이 과정
    - `node` 배열에 기록
        - 수가 연속했는지 아닌지를 판단한 뒤 만약 연속한 수라면 idx를 올려주지 않고, 연속하지 않은 수라면 idx를 올려준다.
    - 사촌 찾기
        - *`node*[*searchIdx*].p != n.p` 사촌의 수 구해야할 노드와 현재 노드의 부모가 다르며
        - *`node*[*searchIdx*].d == n.d depth`가 같은 경우
        - *`node*[*node*[*searchIdx*].idx].p == *node*[n.idx].p` 또한 그 부모의 부모도 같은지 확인해줘야 한다
            - 이 부분을 확인안해줘서 한 번 틀렸었다.. 반례를 보고 해결함