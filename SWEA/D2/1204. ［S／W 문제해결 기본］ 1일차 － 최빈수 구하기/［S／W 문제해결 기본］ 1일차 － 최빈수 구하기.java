import java.io.*;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String TNumber = br.readLine();
            sb.append("#").append(TNumber).append(" ");

            st = new StringTokenizer(br.readLine());

            int[] scores = new int[101];
            for (int j = 0; j < 1000; j++) {
                scores[Integer.parseInt(st.nextToken())]++;
            }

            int max = 0;
            int index = 0;
            for (int j = scores.length - 1; j >= 0; j--) {
                if (scores[j] > max) {
                    max = scores[j];
                    index = j;
                }
            }

            sb.append(index);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
