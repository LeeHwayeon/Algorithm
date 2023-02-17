# 최솟값 만들기

날짜: 2022년 12월 22일
레벨: Level 2
분류: 구현

[코딩테스트 연습 - 최솟값 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12941)

### 내 풀이

```jsx
function solution(A,B){
    var answer = 0;
    const arrayA = A.sort((a,b) => a-b);
    const arrayB = B.sort((a,b) => b-a);
    for(let i=0; i<A.length; i++){
        answer += arrayA[i] * arrayB[i];
    }
    return answer;
}
```

- A 배열 최솟값 * B 배열 최댓값이 누적된 값을 최소로 만든다는 것만 캐치하면 되는 문제