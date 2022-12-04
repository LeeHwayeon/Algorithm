# 문자열 나누기

날짜: 2022년 12월 4일
선택: Level 1

[코딩테스트 연습 - 문자열 나누기](https://school.programmers.co.kr/learn/courses/30/lessons/140108)

```jsx
function solution(s) {
    let answer = 0; // 분해한 문자열 개수
    let x = "";
    let sameCount = 0; // x와 같은 글자
    let diffCount = 0; // x와 다른 글자
    
    for(let c of s){
        if(!x) x = c; // x가 비어있는 경우
        
        if(x === c) sameCount++;
        else diffCount++;
        
        if(sameCount === diffCount){ // 횟수가 같아지면 초기화
            answer++;
            x = "";
            sameCount = 0;
            diffCount = 0;
        }
    }
    
    if(x) answer++; // 반복문 끝났는데 x가 있을경우 남은 문자열이므로 +1
    
    return answer;
}
```