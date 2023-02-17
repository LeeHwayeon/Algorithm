# 오픈채팅방

날짜: 2023년 1월 18일
레벨: Level 2
분류: 구현
언어: Javascript
출제기관: 프로그래머스

## 문제

[코딩테스트 연습 - 오픈채팅방](https://school.programmers.co.kr/learn/courses/30/lessons/42888)

- 2019 KAKAO BLIND RECRUITMENT

## 내 풀이

```jsx
function solution(record) {
    var answer = [];
    let log = {};
    for(const r of record){
        const arr = r.split(" "); //공백으로 분리
        let id = arr[1];
        let name = arr[2]; //Leave일 경우에는 없음
        if(name){ //Enter, Change인 경우에만 이름 저장
            log[id] = name;
        }
    }
    for(const r of record){
        const arr = r.split(" "); //공백으로 분리
        let name = log[arr[1]];
        if(arr[0] === "Enter"){
            answer.push(name+"님이 들어왔습니다.");
        }else if(arr[0] === "Leave"){
            answer.push(name+"님이 나갔습니다.");
        }
    }
    return answer;
}
```

- 자바스크립트의 객체 개념을 이용하면 되는 문제
    - Enter, Change의 경우만 log[id]에 이름을 저장하면 자동으로 변경된 이름이 저장됨
- 다시 반복문 돌면서 이름에 맞게 출력하면 끝
- 자바로 풀었다면 아마 Map이나 Set을 이용하지 않았을까?