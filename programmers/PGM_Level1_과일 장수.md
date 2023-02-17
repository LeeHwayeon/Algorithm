# 과일 장수

날짜: 2022년 12월 7일
선택: Level 1

[코딩테스트 연습 - 과일 장수](https://school.programmers.co.kr/learn/courses/30/lessons/135808)

### 내 풀이

```jsx
function solution(k, m, score) {
    var answer = 0;
    score.sort((a,b) => b-a); // 내림차순 정렬
		
		// m-1번째 있는 값이 제일 작음
    for(let i = m-1; i < score.length; i += m){
        answer += score.at(i) * m * 1;
    }
    return answer;
}
```