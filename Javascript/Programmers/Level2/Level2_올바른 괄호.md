# 올바른 괄호

날짜: 2023년 1월 4일
레벨: Level 2
분류: 스택/큐

[코딩테스트 연습 - 올바른 괄호](https://school.programmers.co.kr/learn/courses/30/lessons/12909)

### 내 풀이

```jsx
function solution(s){
    var answer = true;
    const stack = [];
    for(const str of s){
        if(stack.length === 0){
            if(str === ")"){
                return false;
            }
            stack.push(str);
        }else{
            if(str === "("){
                stack.push(str);
            }else{
                stack.pop();
            }
        }
    }
    if(stack.length !== 0){
        answer = false;
    }
    return answer;
}
```

- stack 길이가 0인데 닫는 괄호가 나오면 무조건 false