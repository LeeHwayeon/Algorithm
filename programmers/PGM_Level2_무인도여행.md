# 무인도 여행

날짜: 2023년 3월 14일
레벨: Level 2
분류: BFS/DFS
언어: Javascript
출제기관: 프로그래머스

## 문제

[](https://school.programmers.co.kr/learn/courses/30/lessons/154540)

## 내 풀이

```jsx
const bfs = (maps, i,j, visited) => {
    const di = [-1,1,0,0];
    const dj = [0,0,-1,1];
    
    let queue = [[i,j]];
    let sum = Number(maps[i][j]);
    visited[i][j] = true;
    
    while(queue.length > 0){
        const [nowx, nowy] = queue.shift();
        
        for(let d=0; d<4; d++){
            let nexti = nowx + di[d];
            let nextj = nowy + dj[d];
            if(nexti <0 || nexti >=maps.length || nextj < 0 || nextj >= maps[0].length || visited[nexti][nextj] || maps[nexti][nextj] === 'X'){
                continue;
            }
            queue.push([nexti,nextj]);
            sum+=Number(maps[nexti][nextj]);
            visited[nexti][nextj] = true;
        }
    }
    return sum;
}

const solution = (maps) => {
    let answer = [];
    let visited = Array.from(Array(maps.length), () => Array(maps[0].length).fill(false));

    for(let i=0; i<maps.length; i++){
        for(let j=0; j<maps[0].length; j++){
            if(!visited[i][j] && maps[i][j] !== 'X'){
                answer.push(bfs(maps, i,j, visited));
            }
        }
    }
    
    if(answer.length === 0){
        return [-1];
    }else{
        return answer.sort((a,b) => a-b);
    }
}
```

- BFS를 이용해서 연결돼 있는 무인도를 합하면 되는 문제
- Array.from으로 이중배열 생성, 프로그래머스에서 문제 풀이할때 js 함수 분리하는 법을 알게 됐다