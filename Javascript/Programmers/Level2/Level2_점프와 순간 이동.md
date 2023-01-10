# 점프와 순간 이동

날짜: 2023년 1월 10일
레벨: Level 2

[코딩테스트 연습 - 점프와 순간 이동](https://school.programmers.co.kr/learn/courses/30/lessons/12980)

- Summer/Winter Coding(~2018)

### 내 풀이

```jsx
function solution(n)
{
    let ans = Number.MAX_VALUE;
    const move = (now, d, battery) => {
        if(now == n){
            ans = Math.min(ans, battery);
            return;
        }
        if(now > n){
            return;
        }
        
        // 점프
        move(now + 1, now + 1, battery + 1);
        // d * 2 순간이동
        move(d * 2, d * 2, battery);
    }
    
    move(1,1,1); // 처음에 한 칸 점프한 뒤 시작

    return ans;
}
```

- 처음에 DFS로 풀었더니 시간초과가 났다

```jsx
function solution(n)
{
    let ans = 0;
    while(n !== 0){
        if(n % 2 === 1){
            n -= 1;
            ans++;
        }else{
            n /= 2;
        }
    }

    return ans;
}
```

- N칸이 홀수일 경우에는 점프를 했고, 짝수일 경우엔 순간이동을 했다는 뜻
- 점프한 경우에만 +1을 해주면서 0이 될때까지 반복