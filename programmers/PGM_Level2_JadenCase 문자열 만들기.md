# JadenCase 문자열 만들기

날짜: 2022년 12월 15일
레벨: Level 2
분류: 구현

[코딩테스트 연습 - JadenCase 문자열 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12951)

### 내 풀이

```jsx
function solution(s) {
    return s.split(" ").map((str) => str.slice(0,1).toUpperCase() + str.slice(1,str.length).toLowerCase()).join(" ");
}
```