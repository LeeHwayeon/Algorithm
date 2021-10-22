# [X보다 작은수](https://www.acmicpc.net/problem/10871)

## 문제
정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.

## 입력
첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000)
둘째 줄에 수열 A를 이루는 정수 N개가 주어진다. 주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
```
10 5
1 10 4 9 2 3 8 5 7 6
```

## 출력
X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다. X보다 작은 수는 적어도 하나 존재한다.
```
1 4 2 3
```

## 답
```javascript
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

//첫째 줄의 10, 5를 N, X에 담는다.
let numbers = input[0].split(' ');
let N = Number(numbers[0]); //10
let X = Number(numbers[1]); //5

//둘째 줄의 수열 A
let A = input[1].split(' ');

//결과를 담을 변수
let result= '';

for(let i=0; i<N; i++){
    if(Number( A[i]) < X ){
        result += A[i] + ' ';
    }
}
console.log(result);
```

## 풀이인증
![image](https://user-images.githubusercontent.com/33210124/138402161-7187e3de-57e0-4b5d-909e-2d35af018b4f.png)

