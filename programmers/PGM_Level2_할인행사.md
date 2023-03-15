# 할인 행사

날짜: 2023년 3월 15일
레벨: Level 2
분류: 자료구조
언어: Javascript
출제기관: 프로그래머스

## 문제

[](https://school.programmers.co.kr/learn/courses/30/lessons/131127)

## 내 풀이

```jsx
function solution(want, number, discount) {
    const calculate = (d) => {
        const wantMap = new Map();
        // 해당 item이 있다면 그 값을 가져와서 +1, 없다면 0+1
        d.forEach((item) => wantMap.set(item, (wantMap.get(item) || 0) + 1));
        for(let i=0; i<want.length; i++){
            // 개수가 하나라도 안 맞는게 있다면 false
            if(wantMap.get(want[i]) !== number[i]) return false;
        }
        return true;
    }
    let answer = 0;
    for(let i=0; i<discount.length-9; i++){
        const d = discount.slice(i, i+10);
        if(calculate(d)){
            answer++;
        }
    }
    return answer;
}
```

- map을 이용해서 discount배열을 10개로 쪼갠 배열에 담긴 할인 제품들을 카운트 해준다