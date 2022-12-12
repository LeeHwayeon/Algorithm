# 없는 숫자 더하기

날짜: 2022년 12월 12일
선택: Level 1

[코딩테스트 연습 - 없는 숫자 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/86051)

### 내 풀이

```jsx
function solution(numbers) {
    var answer = 0;
    let check = new Array(10).fill(false);
    numbers.forEach(num => check[num] = true);
    check.forEach((bool, index) => {
        if(!bool) answer += index;
    });
    return answer;
}
```

### 다른 사람 풀이

```jsx
function solution(numbers) {
    var answer = 0;
    for(let i=0; i<10; i++){
        if(!numbers.includes(i)) answer += i;
    }
    return answer;
}
```

- `includes` 를 기억하자~~