import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15649 {
	static int N,M;
	static int[] array, result;
	static int num;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(line.nextToken()); //1~N
		M = Integer.parseInt(line.nextToken()); //M개 고르기
		
		array = new int[N];
		result = new int[M];
		visited = new boolean[N];
		num = 1;
		
		for(int i=0; i<N; i++) {
			array[i] = num++;
		}
//		System.out.println(Arrays.toString(array));
		
		permu(0);
		
	}
	
	public static void permu(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		
		for(int i=0; i<N; i++) {
			if(visited[i]) {
				continue;
			}
			
			result[cnt] = array[i];
			visited[i] = true;
			
			permu(cnt+1);
			
			visited[i] = false;
			
		}
	}

}
