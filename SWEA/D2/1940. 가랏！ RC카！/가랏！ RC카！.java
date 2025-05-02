import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			int N = Integer.parseInt(br.readLine());
			
			int move = 0;
			int velocity = 0;
			int currentVelocity = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				
				if (command != 0) {
					velocity = Integer.parseInt(st.nextToken());
				}
				
				if (command == 1) {
					currentVelocity += velocity;
					move += currentVelocity;
					
				} else if (command == 2) {
					if (currentVelocity < velocity) {
						currentVelocity = 0;
					} else {
						currentVelocity -= velocity;
					}
					
					move += currentVelocity;
					
				} else {
					move += currentVelocity;
				}
			}
			
			sb.append(move).append("\n");
		}
		
		System.out.println(sb);
	}
}
