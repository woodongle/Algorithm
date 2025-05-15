import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, String> map = new HashMap<>();
		map.put(")", "(");
		map.put("]", "[");
		
		while (true) {
			Deque<String> stack = new ArrayDeque<>();
			
			String[] split = br.readLine().split("");

			if (split[0].equals(".")) {
				return;
			}
			
			for (int i = 0; i < split.length; i++) {
				String str = split[i];
				
				if (str.equals("(") ||
					str.equals(")") ||
					str.equals("[") ||
					str.equals("]")) {
					
					if (!stack.isEmpty() && stack.peekLast().equals(map.get(str))) {
						stack.removeLast();
						continue;
					}
					
					stack.addLast(str);
				}
			}
			
			if (stack.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
