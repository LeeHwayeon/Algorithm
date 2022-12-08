# 푸드파이터 대회

날짜: 2022년 12월 8일
선택: Level 1

[코딩테스트 연습 - 푸드 파이트 대회](https://school.programmers.co.kr/learn/courses/30/lessons/134240?language=javascript)

### 내 풀이

```jsx
function solution(food) {
    var answer = '';
    let results = [];
    food.forEach((num, index) => {
        let count = parseInt(num/2);
        if(count !== 0){
            for(let i=0; i<count; i++){
                results.push(index);
            }
        }
    });
    answer += results.join('');
    answer += "0";
    let idx = results.length;
    for(let i=0; i<idx; i++){
        answer += results.pop();
    }
    return answer;
}
```

- 뭔가 풀면서도 더 쉬운 방법이 있을 것 같은데… 했는데 역시나 있었다

### 다른 사람 풀이

```jsx
function solution(food) {
    let answer = '';
    for(let i=1; i<food.length; i++){
        answer += String(i).repeat(parseInt(food[i]/2));
    }
    answer += "0" + [...answer].reverse().join('');
    return answer;
}
```