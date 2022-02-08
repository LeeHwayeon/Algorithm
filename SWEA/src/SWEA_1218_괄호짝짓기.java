import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {
	static Stack<Character> stack;
	static int N; // 괄호 맞는지 확인할 횟수
	static String st; // 입력값
	static char s;
	static int result; // 유효값

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 10개의 테스트 케이스
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			st = br.readLine();
			result = 1; //유효값을 1로 세팅
			stack = new Stack<Character>();

			for (int i = 0; i < N; i++) {
				s = st.charAt(i);

				//스택안에 값이 있다면
				if (!stack.isEmpty()) {
					switch (stack.peek()) { //스택안에 있는 값을 꺼내서 입력받은 s랑 비교
					case '(':
						if (s == ')') { // 닫는 괄호 일치하면 뺀다
							stack.pop();
							break;
						} else if (s == '}' || s == ']' || s == '>') { // 괄호 일치하지 않을때 유효하지 않음
							result = 0;
							break;
						} else { // 시작괄호가 들어오면 푸시
							stack.push(s);
							break;
						}
					case '{':
						if (s == '}') { // 닫는 괄호 일치하면 뺀다
							stack.pop();
							break;
						} else if (s == ')' || s == ']' || s == '>') { // 괄호 일치하지 않을때 유효하지 않음
							result = 0;
							break;
						} else { // 시작괄호가 들어오면 푸시
							stack.push(s);
							break;
						}
					case '[':
						if (s == ']') { // 닫는 괄호 일치하면 뺀다
							stack.pop();
							break;
						} else if (s == '}' || s == ')' || s == '>') { // 괄호 일치하지 않을때 유효하지 않음
							result = 0;
							break;
						} else { // 시작괄호가 들어오면 푸시
							stack.push(s);
							break;
						}
					case '<':
						if (s == '>') { // 닫는 괄호 일치하면 뺀다
							stack.pop();
							break;
						} else if (s == '}' || s == ']' || s == ')') { // 괄호 일치하지 않을때 유효하지 않음
							result = 0;
							break;
						} else { // 시작괄호가 들어오면 푸시
							stack.push(s);
							break;
						}

					}
				} 
				
				if(stack.isEmpty()) { // 스택이 비어있으면
					stack.push(s); // 입력받은 s값 푸시
				}

			}

			System.out.println("#" + tc + " " + result);
		}
	}

}