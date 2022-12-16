# 체육복

날짜: 2022년 12월 16일
레벨: Level 1
분류: 그리디

[코딩테스트 연습 - 체육복](https://school.programmers.co.kr/learn/courses/30/lessons/42862)

### 내 풀이

```jsx
function solution(n, lost, reserve) {
    var answer = 0;
    let array = new Array(n).fill(1);
    lost.forEach((num) => array[num - 1]--);
    reserve.forEach((num) => array[num - 1]++);
    array.forEach((num, index) => {
        if(num === 0){
            if(index-1 >= 0 && array[index-1] > 1){
                array[index-1]--;
                array[index]++;
            }else if(array[index+1]>1 && index+1 < array.length){
                array[index+1]--;
                array[index]++;
            }
        }
    });
    array.forEach((num) => {if(num > 0) answer++});
    return answer;
}
```

- 먼저 배열을 1로 채워놓은 다음 도난 체육복, 여벌 체육복 판단해서 값 변경해줌
- array 배열 돌리면서 값이 0인 인덱스 앞 뒤로 확인해서 여벌 체육복 있음 1로 변경해줌
- 최종적으로 array 배열 돌려서 카운트 셈