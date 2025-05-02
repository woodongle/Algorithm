import java.io.*;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append("\n");
			
			int N = Integer.parseInt(br.readLine());
			
			for (int money : moneys) {
				if (N < money) {
					sb.append(0).append(" ");
					continue;
				}
				
				sb.append(N / money).append(" ");
				N %= money;
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
