# 행렬 테두리 회전하기

날짜: 2022년 12월 16일
레벨: Level 2
분류: 구현

[코딩테스트 연습 - 행렬 테두리 회전하기](https://school.programmers.co.kr/learn/courses/30/lessons/77485)

### 내 풀이

```jsx
function solution(rows, columns, queries) {
    const answer = [];
    
    // map 생성
    let map = new Array(rows);
    let count = 1;
    for(let i=0; i<rows; i++){
        map[i] = new Array();
        for(let j=0; j<columns; j++){
            map[i].push(count++);
        }
    }
    
    const di = [0,1,0,-1]; // 우 하 좌 상
    const dj = [1,0,-1,0];
    
    queries.forEach((item) => {
        let dir = 0; // 방향
        const [starti, startj, endi, endj] = item.map((num) => num-1);
        
        let nowi = starti;
        let nowj = startj;
        let now = map[starti][startj];
        let temp = 0;
        let next = 0;
        let min = rows * columns + 1;
        while(true){
            min = Math.min(min, now); // 최솟값 비교
            
            let nexti = nowi+di[dir];
            let nextj = nowj+dj[dir];
                        
            if(nexti > endi || nexti < starti || nextj > endj || nextj < startj){
                dir++; // 방향 전환
                nexti = nowi+di[dir];
                nextj = nowj+dj[dir];
            }
            
            temp = map[nexti][nextj];
            map[nexti][nextj] = now;
            now = temp;
            
            nowi = nexti;
            nowj = nextj;
            
            if(dir === 3 && nexti === starti && nextj === startj){
                answer.push(min);
                return;
            }
        }
    });
    return answer;
}
```