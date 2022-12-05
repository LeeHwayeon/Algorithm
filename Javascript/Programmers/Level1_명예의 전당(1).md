# 명예의 전당(1)

선택: Level 1

[코딩테스트 연습 - 명예의 전당 (1)](https://school.programmers.co.kr/learn/courses/30/lessons/138477)

### 내 풀이

```jsx
function solution(k, score) {
    let answer = [];
    let arr = [];

    for(let i=0; i<score.length; i++){        
        if(i<k){
            arr.push(score[i]);
        }
        if(score[i] > Math.min(...arr)){
            arr.pop();
            arr.push(score[i]);
            arr.sort((a,b) => b-a);
        }
        answer.push(arr.at(-1));
    }

    return answer;
}
```

### 다른 사람의 풀이

```jsx
function solution(k, score) {
    let answer = [];
    let arr = [];
    
    for(let i=0; i<score.length; i++){        
        arr.push(score[i]);
        arr.sort((a,b) => b-a);
        if(i > k-1){
            arr.pop();
        }
        answer.push(arr.at(-1));
    }
    
    return answer;
}
```

훨씬 더 간단한듯!