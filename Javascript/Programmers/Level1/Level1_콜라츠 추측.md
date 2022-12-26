# 콜라츠 추측

날짜: 2022년 12월 26일
레벨: Level 1
분류: 구현

[코딩테스트 연습 - 콜라츠 추측](https://school.programmers.co.kr/learn/courses/30/lessons/12943)

### 내 풀이

```jsx
// 재귀
function solution(num) {
    let answer = 0;
    const repeat = (num, cnt) => {
        if(num === 1) return answer = cnt;
        if(cnt >= 500) return answer = -1;
        
        const n = num % 2 === 0 ? num = num / 2 : num = num * 3 + 1;
        repeat(n, cnt+1);
    }
    
    repeat(num, 0);
    return answer;
}

// 반복문
function solution(num) {
    let cnt = 0;
    let n = num;
    while(num !== 1 && cnt < 500){
        n = num % 2 === 0 ? num = num / 2 : num = num * 3 + 1;
        cnt++;
    }
    return cnt < 500 ? cnt : -1;
}
```

- 재귀를 이용해서 풀었다
- 다른 사람들 풀이 찾아보니 while 반복문으로 푼 사람도 있었음