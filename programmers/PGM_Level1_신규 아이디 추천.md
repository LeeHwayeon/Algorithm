# 신규 아이디 추천

날짜: 2023년 1월 25일
레벨: Level 1
분류: 정규표현식
언어: Javascript
출제기관: 프로그래머스

## 문제

[코딩테스트 연습 - 신규 아이디 추천](https://school.programmers.co.kr/learn/courses/30/lessons/72410)

- 2021 KAKAO BLIND RECRUITMENT

## 내 풀이

```jsx
function solution(new_id) {
    let answer = new_id
        .toLowerCase() // 1단계
        .replace(/[^a-z0-9\-\_\.]/g,"") // 2단계
        .replace(/\.+/g, ".") // 3단계
        .replace(/^\.|\.$/, ""); // 4단계
    if(answer.length === 0){ // 5단계
        answer += "a";
    }
    answer = answer.slice(0, 15).replace(/\.$/, ""); //6단계
    let len = answer.length;
    return answer.length <= 2 ? answer + answer.charAt(len - 1).repeat(3 - len) : answer;
}
```

- 정규표현식 문제…
    - `replace(/[^a-z0-9\-\_\.]/g,"")` : 알파벳 a-z, 숫자 0-9, 특수문자 -,_,.을 제외하고 공백으로 바꾸라는 것! 대괄호 안에 ^ 표시가 있으면 부정의 의미임
    - `replace(/\.+/g, ".")` : 전역(g)을 돌면서.이 한개 이상일경우(+) 하나로 바꿔라
    - `replace(/^\.|\.$/, "")` : 첫글자(^)가 .으로 시작하거나 마지막글자($)가 .으로 시작할 경우 공백으로 바꿔라! 대괄호 밖에 ^ 표시가 있으면 첫글자의 의미임