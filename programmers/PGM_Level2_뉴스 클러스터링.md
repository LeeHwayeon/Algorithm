# 뉴스 클러스터링

날짜: 2022년 12월 27일
레벨: Level 2

[코딩테스트 연습 - [1차] 뉴스 클러스터링](https://school.programmers.co.kr/learn/courses/30/lessons/17677)

- 2018 카카오 블라인드

### 내 풀이

```jsx
function solution(str1, str2) {
    var answer = 0;
    const arr1 = divide(str1);
    const arr2 = divide(str2);
    const newArr = new Set([...arr1, ...arr2]);
    if(arr1.length === 0 && arr2.length === 0){ // 만약 공집합이면
        return 65536;
    }
    let intersection = 0; // 교집합
    let union = 0; // 합집합
    newArr.forEach((item) => {
        let a = arr1.filter(x => x===item).length;
        let b = arr2.filter(x => x===item).length;
        union += Math.max(a,b);
        intersection += Math.min(a,b);
    });
    return Math.floor(intersection/union * 65536);
}

const divide = (str) => {
    const regex = /^[a-z|A-Z]+$/;
    let result = [];
    for(let i=0; i+1<str.length; i++){
        let newStr = str[i]+str[i+1];
        if(regex.test(newStr) && newStr.trim().length === 2){ //영어만 있고, 공백제거했을때 길이가 2일때
            result.push(newStr.toUpperCase());   
        }
    }
    return result;
}
```

- 처음에 합집합과 교집합 구할때 set이용해서 안했을때는 4,7,9,10,11 테케가 통과 안됐음
- 구글링해서.. 찾은 결과 new Set으로 중복 제거한 뒤 큰 값은 합집합에, 작은 값은 교집합에 더해주면 간단하게 해결 가능