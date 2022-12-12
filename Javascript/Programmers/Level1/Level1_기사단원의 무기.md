# 기사단원의 무기

날짜: 2022년 12월 7일
선택: Level 1

[코딩테스트 연습 - 기사단원의 무기](https://school.programmers.co.kr/learn/courses/30/lessons/136798)

## 내풀이

처음 풀이

```jsx
function solution(number, limit, power) {
    var answer = 0;
    for(let i=1; i<=number; i++){
        let count = 0;
        for(let j=1; j<=i; j++){
            if(i % j === 0){
                count++;
            }
        }
        answer += count > limit ? power : count;
    }
    return answer;
}
```

- 시간 초과 9개ㅠ

두 번째

```jsx
function solution(number, limit, power) {
    var answer = 0;
    for(let i=1; i<=number; i++){
        let count = 0;
        for(let j=1; j<=i; j++){
            if(i % j === 0){
                count++;
            }
            if(count > limit){
                count = power;
                break;
            }
        }
        answer += count;
    }
    return answer;
}
```

- 약수 개수 count 할 때 limit 보다 넘어가면 안하게 처리함 → 그랬더니 시간초과 8개

최종

```jsx
function solution(number, limit, power) {
    var answer = 0;
    for(let i=1; i<=number; i++){
        let count = 0;
        for(let j=1; j*j<=i; j++){
            if(i % j === 0){
                count++;
                if(j * j < i){
                    count++;
                }
            }
            if(count > limit){
                count = power;
                break;
            }
        }
        answer += count;
    }
    return answer;
}
```

- 약수의 개수 구할 때 해당 숫자의 가장 큰 약수는 `최대 절반`인 것을 기억하자!