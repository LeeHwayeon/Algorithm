# 예상 대진표

날짜: 2023년 1월 3일
레벨: Level 2
분류: 구현

[코딩테스트 연습 - 예상 대진표](https://school.programmers.co.kr/learn/courses/30/lessons/12985)

- 2017 팁스타운

### 내 풀이

```jsx
function solution(n,a,b)
{
    let answer = 0;
    while(a !== b){
        a = Math.ceil(a/2);
        b = Math.ceil(b/2);
        answer++;
    }
    return answer;
}
```

- 단순하게 생각하면 될 것을 굉장히 빙빙 돌려 생각하다 보니 한 번 틀림… 구글링 해서 풀었다..

### Math 메소드 정리

- Math.abs()
- Math.min()
- Math.max()
- Math.random()
    - 0보다 크거나 같고 1보다 작은 무작위 숫자 반환
- Math.round()
    - 반올림
- Math.floor()
    - 내림
- Math.ceil()
    - 올림
- Math.sin()