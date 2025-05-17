import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if (command.equals("push")) {
				int value = Integer.parseInt(st.nextToken());
				stack.push(value);
				
				continue;
			} else if (command.equals("pop")) {
				if (stack.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(stack.pop());	
				}
			} else if (command.equals("size")) {
				sb.append(stack.size());
			} else if (command.equals("empty")) {
				if (stack.isEmpty()) {
					sb.append(1);
				} else {
					sb.append(0);
				}
			} else if (command.equals("top")) {
				if (stack.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(stack.peek());					
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
