# 네트워크

날짜: 2023년 2월 15일
레벨: Level 3
분류: BFS/DFS, 유니온파인드
언어: Javascript
출제기관: 프로그래머스

## 문제

[](https://school.programmers.co.kr/learn/courses/30/lessons/43162)

## 내 풀이

```jsx
// union-find
function solution(n, computers) {
    let parents = new Array(n);
    for(let i=0; i<n; i++){ //부모 자기 자신으로 세팅
        parents[i] = i;
    }
    
    const findParent = (num) => { // 부모찾기
        if(parents[num] === num){
            return num;
        }
        return parents[num] = findParent(parents[num]);
    }
    
    const union = (a,b) => { // 하나로 합치기
        let aRoot = findParent(a);
        let bRoot = findParent(b);
        if(aRoot !== bRoot){
            parents[bRoot] = aRoot;
        }
    }
    
    for(let i=0; i<n; i++){
        for(let j=0; j<n; j++){
            if(i === j) continue; //자기자신은 제외
            if(computers[i][j] === 1){ // 연결되어 있는 경우만 탐색
                union(i,j);
            }
        }
    }
    
    let set = new Set(); //중복제거하기 위해서
    for(const p of parents){
				// 위에서 for문을 돌며 부모를 찾았지만 최상단 부모까지 갱신되지 않은 경우를 제거해주기 위해 한번 더 부모 찾기
        const realP = findParent(p); 
        set.add(realP);
    }
    
    return set.size;
}
```

- 분류는 BFS/DFS로 되어 있으나 결국 연결되어 있으려면 루트노드가 다 똑같을것이라고 생각해 유니온파인드가 생각나 유니온파인드로 풀어봤다
- 일반적인 유니온파인드처럼 풀이해주면 되고 주의할 점은 마지막에 갱신된 부모 배열을 돌면서 한번 더 부모를 찾는 작업을 수행해줘야 한다는 점 ..!
    - 어떤 요소는 루트노드를 가리키지 않는 경우가 있다고 한다.. 요거땜에 좀 애먹음
    - dfs로 푸는게 더 간단했을거 같기도 하고..?

```jsx
// dfs
function solution(n, computers) {
    let answer = 0;
    let visited = new Array(n).fill(false);
    
    const dfs = (i) => {
        visited[i] = true;
        
        for(let j=0; j<n; j++){
						// 자기 자신이 아니고 방문하지 않았고 연결되어 있을때
            if(i != j && !visited[j] && computers[i][j] === 1){
                dfs(j);
            }
        }
    }
    
    for(let i=0; i<n; i++){
        if(!visited[i]){
            dfs(i);
            answer++;
        }
    }
 
    return answer;
}
```