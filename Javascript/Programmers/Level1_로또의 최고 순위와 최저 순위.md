# 로또의 최고 순위와 최저 순위

선택: Level 1

[코딩테스트 연습 - 로또의 최고 순위와 최저 순위](https://school.programmers.co.kr/learn/courses/30/lessons/77484)

### 내 풀이

```jsx
function solution(lottos, win_nums) {
    let answer = [];
    lottos.sort((a,b) => a-b);
    win_nums.sort((a,b) => a-b);
    let zero = 0;
    let same = 0;

    for(let num of lottos){
        if(num === 0){
            zero++;
        }else{
            for(let num2 of win_nums){
                if(num === num2){
                    same++;
                    break;
                }
            }
        }
    }
    const rank = (num) => {
        switch(num){
            case 6 : return 1;
            case 5 : return 2;
            case 4 : return 3;
            case 3 : return 4;
            case 2 : return 5;
            default : return 6;
        }
    }

    answer.push(rank(zero+same));
    answer.push(rank(same));
    return answer;
}
```

### 다른 사람의 풀이

```jsx
function solution(lottos, win_nums) {
    const rank = [6, 6, 5, 4, 3, 2, 1];

    const min = lottos.filter(n => win_nums.includes(n)).length;
    const max = lottos.filter(n => n === 0).length + min;

    return [rank[maxCount], rank[minCount]];
}
```

rank 배열 센스가 굿…

`filter` 랑 `includes` 를 잘 쓰면 훨씬 간단하군…!