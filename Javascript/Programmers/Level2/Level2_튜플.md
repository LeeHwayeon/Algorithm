# 튜플

날짜: 2022년 12월 21일
레벨: Level 2
분류: 구현

[코딩테스트 연습 - 튜플](https://school.programmers.co.kr/learn/courses/30/lessons/64065)

- 2019 카카오 개발자 겨울 인턴십

### 내 풀이

```jsx
function solution(s) {
    var answer = [];
    let str = s.replace("{{", "").replace("}}", "").split("},{"); // 괄호, 쉼표 제거후 새로운 배열 생성
    let tuple = str.map((item) => {
        let arr = item.split(",");
        return arr;
    })
    tuple.sort((a,b) => a.length-b.length); // 길이 정렬
    tuple.forEach((item) => {
        item.forEach((i) => {
            if(!answer.includes(Number(i))) answer.push(Number(i));
        });
    });
    return answer;
}
```

---

```jsx
function solution(s) {
    var answer = [];
    let str = s.slice(2,-2).split("},{").sort((a,b) => a.length-b.length);
    str.forEach((item) => {
        let arr = item.split(",").forEach((i) => {
            if(!answer.includes(Number(i))) answer.push(Number(i));
        });
    });
    return answer;
}
```

- {{ 랑 }} 를 그냥 slice(2,-2)로 하는게 훨씬 간단하고 정렬도 바로 해주기!
- 새로운 배열에 담을 필요없이 str 돌면서 answer에 넣어주면 훨씬 간단해진다