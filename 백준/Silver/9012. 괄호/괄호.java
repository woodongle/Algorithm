import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int count = 0;
			
			String line = br.readLine();
			
			for (int j = 0; j < line.length(); j++) {
				char str = line.charAt(j);
				
				if (str == '(' || str == ')') {
					if (count < 0) {
						break;
					}
					
					if (str == '(') {
						count++;
						continue;
					}
					
					if (str == ')') {
						count--;
					}
				}
			}
			
			if (count == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
