# 귤 고르기

날짜: 2023년 2월 1일
레벨: Level 2
분류: 자료구조
언어: Javascript
출제기관: 프로그래머스

## 문제

[코딩테스트 연습 - 귤 고르기](https://school.programmers.co.kr/learn/courses/30/lessons/138476)

## 내 풀이

```jsx
function solution(k, tangerine) {
    let answer = 0;
    let map = new Map();
    tangerine.forEach((item) => {
        if(map.has(item)){
            map.set(item, map.get(item)+1);
        }else{
            map.set(item, 1);
        }
    });
    let array = [...map].sort((a,b) => b[1] - a[1]);
    for(const item of array){
        k = k - item[1];
        answer++;
        if(k <= 0){
            break;
        }
    }
    return answer;
}
```

- 처음에 조합으로 풀었다.. 시간초과 날 줄은 알았지만 다른 방법이 떠오르지 않아서 풀었다,, 역시나 시간초과^^
- 중복된 값의 개수를 확인해서 중복된 값이 큰것부터 k에서 빼야겠다는 방법?은 생각했으나.. 그걸 어떤걸 이용해서 풀어야 할지 감을 못 잡았던 문제..
    - tangerine의 원소가 10,000,000까지니까 그만큼의 배열을 만들어서 확인해야할지..까지 갔다.. ⇒ 이렇게 해봤는데 시간, 메모리 소모 엄청남ㅎㅎ
- 결론은 Map을 이용해서 중복값 확인해준다음 map을 다시 배열로 변경해서 k가 0 이하일때 break