# 우물 안 개구리

날짜: 2023년 1월 16일
레벨: Level3
분류: 구현

# Softeer

[Softeer](https://softeer.ai/practice/info.do?idx=1&eid=394&sw_prbl_sbms_sn=128922)

### 내 풀이

```java
import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 회원수
        int M = Integer.parseInt(st.nextToken()); // 친분관계수
        int[] weight = new int[N+1]; // 각 회원이 들 수 있는 역기 무게
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N+1];
        Arrays.fill(result, 1); //모두 최고라고 세팅

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 더 약한 회원을 0으로
            if(weight[a] > weight[b]){  
                result[b] = 0;
            }else if(weight[a] < weight[b]){
                result[a] = 0;
            }else{ // 똑같을 경우 둘다 0
                result[a] = 0;
                result[b] = 0;
            }
        }

        int cnt = 0;
        for(int n : result){
            if(n > 0) cnt++;
        }
        System.out.println(cnt-1); //0번 제외
    }
}
```