import java.io.*;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            sb.append("#").append(testCase).append(" ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] prefix = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= N; j++) {
                    prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            int limit = N - M + 1;
            for (int i = 1; i <= limit; i++) {
                for (int j = 1; j <= limit; j++) {
                    int sum = prefix[i + M - 1][j + M - 1] - prefix[i - 1][j + M - 1] - prefix[i + M - 1][j - 1] + prefix[i - 1][j - 1];
                    max = Math.max(max, sum);
                }
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}
