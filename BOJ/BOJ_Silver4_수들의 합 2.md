# 수들의 합 2

날짜: 2022년 12월 22일
레벨: Silver
분류: 투포인터
상세레벨: Silver4

[2003번: 수들의 합 2](https://www.acmicpc.net/problem/2003)

### 내 풀이

```jsx
const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const [N, M] = input[0].split(" ").map((num) => Number(num));
const array = input[1].split(" ").map((num) => Number(num));

let left = 0;
let right = 0;
let sum = array[left];
let answer = 0;

while (right < N && left < N) {
  if (sum === M) {
    sum -= array[left];
    left++;
    if (right < N) {
      right++;
      sum += array[right];
    }
    answer++;
  }

  if (sum < M) {
    right++; // 오른쪽으로 한 칸 이동
    if (right < N) {
      sum += array[right];
    }
  }

  if (sum > M) {
    sum -= array[left];
    left++;
  }
}
console.log(answer);
```

- 현재 합 < M
    - right 증가 후 sum에 더하기
- 현재 합 > M
    - left 증가 후 sum에서 빼기
- 현재 합 = M
    - answer 증가
    - left, right 증가