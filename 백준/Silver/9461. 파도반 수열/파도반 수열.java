import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            
            if (N <= 3) {
                sb.append(1).append('\n');
                continue;
            } else if (N == 4) {
                sb.append(2).append('\n');
                continue;
            }
            
            long[] dp = new long[N];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 2;
            dp[4] = 2;
            
            for (int i = 5; i < N; i++) {
                dp[i] = dp[i - 5] + dp[i - 1];
            }
            
            sb.append(dp[N - 1]).append('\n');
        }
        
        System.out.println(sb);
    }
}