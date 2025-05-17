import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new ArrayDeque<>();
		Deque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if (command.equals("push")) {
				int value = Integer.parseInt(st.nextToken());
				queue.offerLast(value);
				
				continue;
			} else if (command.equals("pop")) {
				if (queue.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(queue.pollFirst());	
				}
			} else if (command.equals("size")) {
				sb.append(queue.size());
			} else if (command.equals("empty")) {
				if (queue.isEmpty()) {
					sb.append(1);
				} else {
					sb.append(0);
				}
			} else if (command.equals("front")) {
				if (queue.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(queue.peekFirst());					
				}
			} else if (command.equals("back")) {
				if (queue.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(queue.peekLast());					
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
