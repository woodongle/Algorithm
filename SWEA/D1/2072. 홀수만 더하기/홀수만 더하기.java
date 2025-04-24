import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            sb = new StringBuilder();
            int sum = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num % 2 == 0) {
                    continue;
                }

                sum += num;
            }

            sb.append("#").append(i).append(" ").append(sum);
            System.out.println(sb);
        }
    }
}
