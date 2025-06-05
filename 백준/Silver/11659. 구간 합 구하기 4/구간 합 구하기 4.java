import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                dp[i] = Integer.parseInt(st.nextToken());
                continue;
            }
            
            dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());
        }
        
        for (int testCase = 1; testCase <= M; testCase++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            sb.append(dp[j] - dp[i - 1]).append('\n');
        }
        
        System.out.println(sb);
    }
}