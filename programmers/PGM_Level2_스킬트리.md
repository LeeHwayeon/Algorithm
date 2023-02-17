# 스킬트리

날짜: 2023년 1월 20일
레벨: Level 2
분류: 구현
언어: Javascript
출제기관: 프로그래머스

## 문제

[코딩테스트 연습 - 스킬트리](https://school.programmers.co.kr/learn/courses/30/lessons/49993)

- Summer/Winter Coding(~201

## 내 풀이

```jsx
function solution(skill, skill_trees) {
    let answer = 0;
    for(let i=0; i<skill_trees.length; i++){
        const new_skill_trees = [];
        const str = skill_trees[i].split("");
        for(let j=0; j<str.length; j++){
            if(skill.includes(str[j])){
                new_skill_trees.push(str[j]);
            }
        }
        let flag = true;
        for(let j=0; j<new_skill_trees.length; j++){
            if(new_skill_trees[j] !== skill.substring(j, j+1)){
                flag = false;
                break;
            }
        }
        if(flag){
            answer++;
        }
    }
    return answer;
}
```

- `skill_trees`를 돌면서 skill에 포함되어 있는 알파벳만 `new_skill_trees`에 저장 후 `new_skill_trees`와 `skill`의 첫번째 알파벳부터 비교해서 다를 경우에 break문으로 빠져나오게 해서 최종적으로 `flag`가 `true`인 경우에만 카운트를 올려줬다.
- 답은 맞았으나 좀 더 간결한 코드를 다른 사람 풀이를 보면서 참고해서 다시 작성했다.

```jsx
function solution(skill, skill_trees) {
    let answer = 0;
    for(let i=0; i<skill_trees.length; i++){
        const str = skill_trees[i].split("").filter((item) => skill.includes(item));
        let flag = true;
        str.forEach((item, idx) => {
            if(item !== skill.substring(idx, idx+1)){
                flag = false;
            }
        });
        if(flag){
            answer++;
        }
    }
    return answer;
}
```

- 오랜만에 자스로 푸니까 `includes`며,, `filter`며 자꾸 까먹는다…
- `filter`를 이용해서 `skill`에 들어있는 알파벳만 `str`배열에 담아준 후 비교해줬다