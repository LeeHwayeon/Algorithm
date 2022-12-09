# 게임 맵 최단거리

날짜: 2022년 12월 9일
선택: Level 2

[코딩테스트 연습 - 게임 맵 최단거리](https://school.programmers.co.kr/learn/courses/30/lessons/1844)

- 깊이/너비 우선 탐색(DFS/BFS)

### 내 풀이

```jsx
function solution(maps) {
  const di = [-1, 1, 0, 0]; //상, 하, 좌, 우
  const dj = [0, 0, -1, 1];

  let willCheck = [];

  willCheck.push([0, 0]);

  while (willCheck.length !== 0) {
    const node = willCheck.shift();

    if (node[0] === maps.length - 1 && node[1] === maps[0].length - 1) {
      return maps[maps.length - 1][maps[0].length - 1];
    }

    for (let d = 0; d < 4; d++) {
      let nexti = node[0] + di[d];
      let nextj = node[1] + dj[d];
      if (
        nexti < 0 ||
        nexti >= maps.length ||
        nextj < 0 ||
        nextj >= maps[0].length
      ) {
        continue;
      }
      if (maps[nexti][nextj] === 1) {
        willCheck.push([nexti, nextj]);
        maps[nexti][nextj] = maps[node[0]][node[1]] + 1;
      }
    }
  }
  return -1;
}
```

- `bfs` 이용해서 품
- java로 풀 때 처럼 풀었더니 다른 사람들 보다 꽤나 깔끔한 코드인듯..?!
