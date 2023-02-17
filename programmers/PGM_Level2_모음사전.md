# 모음사전

날짜: 2022년 12월 30일
레벨: Level 2
분류: 그리디

[코딩테스트 연습 - 모음사전](https://school.programmers.co.kr/learn/courses/30/lessons/84512)

### 내 풀이

```jsx
function solution(word) {
    var answer = 0;
    const vowel = ["A", "E", "I", "O", "U"];
    const result = [];
    const dfs = (cnt, str) => {
        if(cnt >= vowel.length) return;
        
        result.push(str);
        for(let i=0; i<vowel.length; i++){
            dfs(cnt+1, str+vowel[i]);
        }
    }
    vowel.forEach((item) => dfs(0,item));
		return result.indexOf(word)+1;
}
```

- 완전탐색 돌려서 해당 word 인덱스 출력함

### 다른 풀이

```jsx
let res = {};
let idx = 0;
let arr = ["A", "E", "I", "O", "U"];

const dfs = (now, cnt) => {
    if(cnt>5)   return;
    res[now] = idx++;
    for(let i=0; i<5; i++){
        let next = now + arr[i];
        dfs(next, cnt+1);
    }
}

function solution(word) {
    var answer = 0;
    dfs("", 0);
    return res[word];
}
```

- 객체를 이용해서 풀이한 게 조금 더 간단한 것 같음