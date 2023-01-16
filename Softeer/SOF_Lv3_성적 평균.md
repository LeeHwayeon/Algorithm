# 성적 평균

날짜: 2023년 1월 16일
레벨: Level3
분류: 구현

# Softeer

[Softeer](https://softeer.ai/practice/info.do?idx=1&eid=389&sw_prbl_sbms_sn=127891)

### 내 풀이

```java
import java.util.*;
import java.io.*;

public class Main
{
    static int N,K,students[];
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //학생 수
        K = Integer.parseInt(st.nextToken()); //구간 수
        students = new int[N+1];

        st = new StringTokenizer(br.readLine());    
        for(int i=1; i<=N; i++){
            students[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine()); 
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(String.format("%.2f",avg(a,b, b-a+1)));
        }

    }

    public static float avg(int start, int end, int count){
        float sum = 0;
        for(int i=start; i<=end; i++){
            sum += students[i];
        }
        return sum/count;
    }
}
```