# 📝 [평균](https://www.acmicpc.net/problem/1546)

## 문제
세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다. 일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M x 100으로 고쳤다.
예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70 x 100이 되어 71.43점이 된다.
세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.


## 입력
첫째 줄에 시험 본 과목의 개수 N이 주어진다. 이 값은 1000보다 작거나 같다. 둘째 줄에 세준이의 현재 성적이 주어진다. 이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.
```javascript
3
10 20 30
```

## 출력
첫째 줄에 새로운 평균을 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-2 이하이면 정답이다.
```javascript
66.666667
```


## 답
```javascript
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

//첫째 줄에 시험 본 과목 개수 N : 3
const N = Number(input[0]);   
//둘째 줄에 현재 성적 : 10 20 30
const array = input[1].split(' ').map(x => Number(x));

//최댓값을 현재 성적 중 가장 첫번째 걸로 지정한다.
let M = array[0];

for(let i=1; i<N; i++){
    if(M < array[i]){
        M = array[i];
    }
}

//모든 점수를 점수/최댓값*100 해준다.
const newArray = array.map((x) => x/M*100);

//합계를 저장할 변수를 설정한다.
let sum = 0;
for(let i=0; i<N; i++){
    sum += newArray[i];
}

console.log(sum/N);
```

## 풀이인증
![image](https://user-images.githubusercontent.com/33210124/139049312-d516ea87-b1c3-45a0-8138-b0dc396cb426.png)
