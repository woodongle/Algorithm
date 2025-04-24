import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            sb.append("#").append(i).append(" ");

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if (num1 > num2) {
                sb.append(">");
            } else if (num1 == num2) {
                sb.append("=");
            } else {
                sb.append("<");
            }

            System.out.println(sb);
        }
    }
}
