# 최댓값과 최솟값

날짜: 2023년 1월 3일
레벨: Level 2
분류: 구현

[코딩테스트 연습 - 최댓값과 최솟값](https://school.programmers.co.kr/learn/courses/30/lessons/12939)

### 내 풀이

```jsx
function solution(s) {
    const array = s.split(" ").map((s) => Number(s));
    array.sort((a,b) => a-b);
    return array.at(0)+" "+array.at(-1);
}
```

- 문자열 숫자 배열로 만들어 준 다음 정렬후 첫번째 값과 마지막 값 출력함

### 다른 사람 풀이

```jsx
function solution(s) {
    const arr = s.split(' ');

    return Math.min(...arr)+' '+Math.max(...arr);
}
```

- 다른 사람 풀이 보다가 발견한 사실.. 자스는 max, min이 문자열도 된다는 사실.. ㄴ😲ㄱ