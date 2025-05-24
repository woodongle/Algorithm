import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] values = new int[N + 1][N + 2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int j = 1;
			while (st.hasMoreTokens()) {
				values[i][j] = Integer.parseInt(st.nextToken());
				
				j++;
			}
		}
		
		if (N == 1) {
			System.out.println(values[1][1]);
			return;
		}
		
		int[][] dp = new int[N + 1][N + 2];
		dp[1][1] = values[1][1];
		dp[2][1] = dp[1][1] + values[2][1];
		dp[2][2] = dp[1][1] + values[2][2];
		
		for (int i = 3; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + values[i][j];
			}
		}
		
		int max = 0;
		
		for (int number : dp[N]) {
			if (number > max) {
				max = number;
			}
		}
		
		System.out.println(max);
	}
}
