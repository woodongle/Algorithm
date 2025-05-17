import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		Deque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < K; i++) {
			int number = Integer.parseInt(br.readLine());
			
			if (number == 0) {
				stack.pop();
				continue;
			}
			
			stack.push(number);
		}
		
		int result = 0;
		
		for (int number : stack) {
			result += number;
		}
		
		System.out.println(result);
	}
}
