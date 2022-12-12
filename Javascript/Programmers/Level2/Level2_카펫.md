# 카펫

날짜: 2022년 12월 12일
선택: Level 2

[코딩테스트 연습 - 카펫](https://school.programmers.co.kr/learn/courses/30/lessons/42842)

### 내 풀이

```jsx
function solution(brown, yellow) {
    var answer = [];
    let area = brown + yellow; // 갈색+노란색 카펫 수가 총 면적
    for(let i=1; i<= area; i++){
        let row = i;
        let col = area/i;
        
        if(row > col) continue; // 가로가 세로보다 작을때
        
        if((row-2) * (col-2) === yellow){
            answer.push(col);
            answer.push(row);
            return answer;
        }
    }
    return answer;
}
```