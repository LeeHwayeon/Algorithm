# 두 개 뽑아서 더하기

날짜: 2022년 12월 15일
레벨: Level 1

[코딩테스트 연습 - 두 개 뽑아서 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/68644)

### 내 풀이

```jsx
function solution(numbers) {
    var answer = [];
    let visited = new Array(numbers.length).fill(false);
    const combi = (cnt, sum) => {
        if(cnt >= 2){
            if(!answer.includes(sum)) answer.push(sum);
            return;
        }
        
        for(let i=0; i<numbers.length; i++){
            if(!visited[i]){
                visited[i] = true;
                combi(cnt + 1, sum + numbers[i]);
                visited[i] = false;
            }
        }
    };
    combi(0,0);
    answer.sort((a,b) => a-b);
    return answer;
}
```

- 뽑아서 더하기라길래 조합을 떠올렸음
- 다른 사람 풀이 보니 그냥 반복문 돌려도 될듯ㅎ