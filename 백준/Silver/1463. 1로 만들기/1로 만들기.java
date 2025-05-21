import java.io.*;

public class Main {
	
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.println(0);
			return;
		}
		
		int[] dp = new int[N + 1];
		dp[1] = 0;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}
		
		System.out.println(dp[N]);
	}
}
