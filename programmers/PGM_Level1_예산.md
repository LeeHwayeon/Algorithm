# 예산

날짜: 2022년 12월 27일
레벨: Level 1
분류: 구현

[코딩테스트 연습 - 예산](https://school.programmers.co.kr/learn/courses/30/lessons/12982)

- Summer/Winter Coding(~2018)

### 내 풀이

```jsx
function solution(d, budget) {
    let answer = 0;
    d.sort((a,b) => a-b);
    let sum = 0;
    for(let i=0; i<d.length; i++){
        sum += d[i];
        if(sum <= budget){
            answer++;
        }else{
            break;
        }
    }
    return answer;
}
```

- 조합 문제인줄 알았으나.. 그냥 정렬문제였음