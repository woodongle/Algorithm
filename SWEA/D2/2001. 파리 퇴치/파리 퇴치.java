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

            int[][] fly = new int[N][N];

            for (int i = 0; i < fly.length; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < fly[0].length; j++) {
                    fly[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            int limit = N - M + 1;
            for (int i = 0; i < limit; i++) {
                for (int j = 0; j < limit; j++) {
                    int sum = 0;

                    for (int k = 0; k < M; k++) {
                        for (int l = 0; l < M; l++) {
                            sum += fly[i + k][j + l];
                        }
                    }

                    max = Math.max(max, sum);
                }
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}
