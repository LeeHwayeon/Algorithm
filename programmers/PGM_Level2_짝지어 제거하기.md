# 짝지어 제거하기

날짜: 2023년 1월 5일
레벨: Level 2
분류: 스택/큐

[코딩테스트 연습 - 짝지어 제거하기](https://school.programmers.co.kr/learn/courses/30/lessons/12973)

- 2017 팁스타운

### 내 풀이

```java
function solution(s)
{
    const stack = [];
    for(const str of s){
        if(stack.length == 0){
            stack.push(str);
        }else{
            const pop = stack.pop();
            if(str !== pop){
                stack.push(pop);
                stack.push(str);
            }
        }
    }
    return stack.length === 0 ? 1 : 0;
}
```

- stack 길이 0일때는 바로 push
- 0보다 클때 하나씩 꺼내서 현재 문자열이랑 같은지 비교
    - 같지 않을 경우에만 꺼낸 값 다시 집어 넣고, 현재 문자열도 다시 넣는다.