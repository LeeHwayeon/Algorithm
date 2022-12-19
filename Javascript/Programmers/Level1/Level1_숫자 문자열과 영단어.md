# 숫자 문자열과 영단어

날짜: 2022년 12월 19일
레벨: Level 1
분류: 구현

[코딩테스트 연습 - 숫자 문자열과 영단어](https://school.programmers.co.kr/learn/courses/30/lessons/81301)

### 내 풀이

```jsx
function solution(s) {
    let answer = "";
    const numbers = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
    
    let check = "";
    for(const char of s){
        if(!isNaN(char)){
            answer += char;
        }else{
            check += char;
        }
        if(check.length >= 3 && numbers.includes(check)){
            answer += numbers.indexOf(check);
            check = '';
        }
    }
    return Number(answer);
}
```

- 숫자들은 먼저 `numbers` 배열에 넣어줌
- s 문자열 돌면서 `isNaN` 으로 숫자인지 확인
    - 숫자일 경우 바로 answer에 담고
    - 문자일 경우 check에 담는다
- check는 계속 확인하면서 길이가 3이상이고 해당 문자열 포함하고 있으면 answer에 담고 check 다시 비워주기
- 마지막 출력할때 숫자로 출력해야 하기 때문에 `Number()`

### 다른 사람 풀이

```jsx
function solution(s) {
    let numbers = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
    var answer = s;

    for(let i=0; i< numbers.length; i++) {
        let arr = answer.split(numbers[i]);
        answer = arr.join(i);
    }

    return Number(answer);
}
```

- `split` 을 이용해서 해당 문자로 분리했던 거를 다시 그 숫자로 join하는 방식..
- 훨씬 간단했다…