import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4344_평균은넘겠지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		int[] students;
		
		for(int i=0; i<tc; i++) {
			String str = br.readLine();
			StringTokenizer line = new StringTokenizer(str, " ");

			int N = Integer.parseInt(line.nextToken());
			
			students = new int[N];
			
			int sum = 0;
			
			for(int j=0; j<students.length; j++) {
				students[j] = Integer.parseInt(line.nextToken());
				sum += students[j];
			}
			
			double avg = sum/students.length;
			
//			System.out.printf("%.3f", avg);
			
			int count = 0;
			for(int j=0; j<students.length; j++) {
				if(avg<students[j]) {
					count++;
				}
			}
			
			System.out.printf("%.3f%n",(double)count*100/students.length);
		}
	}

}
