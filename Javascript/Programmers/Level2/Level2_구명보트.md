# 구명보트

날짜: 2022년 12월 23일
레벨: Level 2
분류: 그리디

[코딩테스트 연습 - 구명보트](https://school.programmers.co.kr/learn/courses/30/lessons/42885)

### 내 풀이

```jsx
function solution(people, limit) {
    var answer = 0;
    people.sort((a,b) => a-b);
    let start = 0;
    let end = people.length - 1;
    while(start < end){
        if(people[start] + people[end] > limit){
            end--;
        }else{
            start++;
            end--;
        }
        answer++;
        if(start === end) answer++;
    }
    return answer;
}
```

- 최대 2명씩만 탑승 가능하기 때문에 투 포인터 이용 가능 ⇒ 이거를 캐치 못해서 구글링 했다..