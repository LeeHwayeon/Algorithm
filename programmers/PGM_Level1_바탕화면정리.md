# 바탕화면 정리

날짜: 2023년 3월 14일
레벨: Level 1
분류: 구현
언어: Javascript
출제기관: 프로그래머스

## 문제

[](https://school.programmers.co.kr/learn/courses/30/lessons/161990)

## 내 풀이

```jsx
function solution(wallpaper) {
    let startx = 51; //파일이 있는 위치 중 최소
    let starty = 51;
    let endx = -1; // 파일이 있는 위치 중 최대
    let endy = -1;

    for(let i=0; i<wallpaper.length; i++){
        for(let j=0; j<wallpaper[i].length; j++){
            if(wallpaper[i][j] === '#'){
                startx = Math.min(startx, i);
                starty = Math.min(starty, j);
                endx = Math.max(endx, i);
                endy = Math.max(endy, j);
            }
        }
    }

    return [startx, starty, (endx+1), (endy+1)];
}
```

- 파일이 있는 위치에서 최소, 최대를 구하면 되는 문제
- end 위치에 +1을 해준 이유는 드래그하는 것이기때문에 그 값까지 포함해야해서