# 호석이 두마리 치킨

날짜: 2023년 4월 22일
레벨: Gold5
분류: 트리
언어: Java
출제기관: 백준

## 문제

[21278번: 호석이 두 마리 치킨](https://www.acmicpc.net/problem/21278)

## 내 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Gold5_21278_호석이두마리치킨 {
    static int N,M, distance[][], isSelected[], ans[];
    static boolean[] visited; //건물 선택여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //건물 개수
        M = Integer.parseInt(st.nextToken()); //도로 개수

        distance = new int[N+1][N+1]; //각 건물들 사이 거리
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                distance[i][j] = 1000000;
                if(i == j) distance[i][j] = 0;
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            distance[a][b] = distance[b][a] = 1; //연결된 도로
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j]; //거리 갱신
                    }
                }
            }
        }

        isSelected = new int[2]; //치킨집 열 곳
        ans = new int[3];
        ans[2] = Integer.MAX_VALUE; //모든 건물에서 가장 가까운 치킨집까지 왕복하는 최단 시간의 총합
        visited = new boolean[N+1];
        combi(0, 1);
        System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
    }

    static void combi(int cnt, int start){
        if(cnt == 2){ //건물 두개 다 고름
            int sum = 0;
            for(int i=1; i<=N; i++){
                //치킨집 열 곳이 아닌 곳에서 치킨집 열 건물과 거리를 계산해보자
                if(i != isSelected[0] && i != isSelected[1]) {
                    // 치킨집 차릴 두군데와의 거리 중 최솟값으로 더해줄 것
                    sum += Math.min(distance[i][isSelected[0]], distance[i][isSelected[1]]);
                }
            }
            if(sum*2 < ans[2]){
                ans[0] = isSelected[0];
                ans[1] = isSelected[1];
                ans[2] = sum*2;
            }
            return;
        }

        for(int i=start; i<=N; i++){
            isSelected[cnt] = i;
            combi(cnt+1, i+1);
        }
    }
```

- 플로이드 와샬을 이용해 각 건물들간의 거리를 미리 구한다음
- 조합으로 치킨집 열 건물 2개를 선택해서 치킨집 열지 않을 건물에서 치킨집 열 건물 2곳 중 최솟값을 더한다음 비교해준다.
- 값이 자꾸 마이너스가 나와서 왜 그런가 했더니 처음에 플로이드 와샬로 건물들간의 거리 계산하기 전 초기화 값으로 Integer.MAX_VALUE를 해서 그랬던것… 적당히 큰 값을 해줬더니 제대로 출력함