# 피로도

날짜: 2022년 12월 13일
레벨: Level 2
분류: 완전탐색

[코딩테스트 연습 - 피로도](https://school.programmers.co.kr/learn/courses/30/lessons/87946)

### 내 풀이

```jsx
function solution(k, dungeons) {
    let answer = 0;
    let visited = new Array(dungeons.length).fill(false);
    let results = [];

    const permu = (cnt) => {
        if(cnt >= dungeons.length){
            let energy = k;
            let max = 0;
            for(let i=0; i<results.length; i++){ //피로도 계산
                if(dungeons[results[i]][0] > energy) continue;
                energy -= dungeons[results[i]][1];
                max++;
            }
            answer = Math.max(max, answer);
        }
        
        for(let i=0; i<dungeons.length; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            results.push(i);
            permu(cnt+1, 0);
            
            visited[i] = false;
            results.pop(i);
        }
    }
    permu(0);
    return answer;
}
```

- 뭔가 순열 중간에 가지치기를 할 수 있을 것만 같았는데.. 생각이 안나 그냥 순열 다 돌린다음 피로도 계산했다

```jsx
function solution(k, dungeons) {
    let answer = 0;
    let visited = new Array(dungeons.length).fill(false);
    let results = [];
    const permu = (cnt, k) => {
        answer = Math.max(cnt, answer);
        
        for(let i=0; i<dungeons.length; i++){
            if(visited[i] || k < dungeons[i][0]) continue;
            
            visited[i] = true;
            permu(cnt+1, k - dungeons[i][1]);
            
            visited[i] = false;
        }
    }
    permu(0, k);
    return answer;
}
```

- 찾아본 결과 역시 중간에 가지치기 하면 됐었음..
- k 계산해서 넘기는 것까지는 생각했는데 종료조건을 줘야한다는 생각에? `answer = Math.max(cnt, answer);` 를 그냥 해도 된다는 생각을 떠올리지 못함ㅠ