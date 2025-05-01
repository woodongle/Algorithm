import java.io.*;

class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			int number = Integer.parseInt(br.readLine());
			for (int i = 2; i <= 11; i++) {
				int count = 0;
				
				if (i == 2 || i % 2 == 1 && i != 9) {
					while (true) {
						if (number % i != 0) {
							break;
						}
						
						number /= i;
						count++;
					}
					
					sb.append(count).append(" ");
				}
			}
			
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
