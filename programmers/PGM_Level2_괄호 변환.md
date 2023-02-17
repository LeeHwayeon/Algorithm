# 괄호 변환

날짜: 2022년 12월 26일
레벨: Level 2

[코딩테스트 연습 - 괄호 변환](https://school.programmers.co.kr/learn/courses/30/lessons/60058?language=javascript)

- 2020 카카오 블라인드

### 내 풀이

```jsx
function solution(p) {
    var answer = '';
    let open = 0;
    let close = 0;
    
    // 1. 입력이 빈 문자열인 경우
    if(p === "") return "";
    
    for(let i=0; i<p.length; i++){
        // 2. 균형잡힌 괄호 확인
        if(p[i] === "(") open++;
        else close++;
        
        // 균형잡힌 괄호일때
        if(open === close){
            // 3. u가 올바른 괄호 문자열임
            if(check(p.slice(0, i+1))) {
                // 3-1
                answer = p.slice(0, i+1) + solution(p.slice(i+1));
                return answer;
            }else{ // 4
                // 4-1, 4-2, 4-3
                answer = "(" + solution(p.slice(i+1)) + ")";
                // 4-4
                for(let j=1; j<i; j++){
                    if(p[j] === "(") answer += ")";
                    else answer += "(";
                }
                return answer;
            }
        }
    }
}
    
const check = (str) => {
    let stack = [];
    for(let s of str){
        if(s === "(") stack.push(s);
        else {
            if(stack.length === 0) return false;
            stack.pop();
        }
    }
    return true;
}
```

- 문제에 제시된 과정대로 구현하면 되는 문제
- 근데 그게 이해가 잘 안가서 구글링 함… 🥲