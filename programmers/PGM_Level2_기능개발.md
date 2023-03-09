# 기능개발

날짜: 2023년 3월 9일
레벨: Level 2
분류: 스택/큐
언어: Java
출제기관: 프로그래머스

## 문제

[](https://school.programmers.co.kr/learn/courses/30/lessons/42586)

## 내 풀이

```java
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<speeds.length; i++){
            int temp = (int)Math.ceil((double)(100 - progresses[i])/speeds[i]);
            queue.add(temp);
        }
        
        int before = queue.poll();
        int idx = 0;
        list.add(1);
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now > before){
                idx++;
                before = now;
                list.add(1);
            }else{
                list.set(idx, list.get(idx)+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
```

- 며칠간 작업을 해야 배포할 수 있는지 queue에 담고 before(전 작업일)을 기준으로 현재 작업일이 더 작거나 같을 경우에는 배포를 같이할 수 있으니 전값에 +1, 클 경우에는 인덱스 증가해서 새로운 배포일을 기록해준다