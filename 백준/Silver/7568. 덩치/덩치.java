import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        int[][] spec = new int[testCase][2];

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            spec[i][0] = weight;
            spec[i][1] = height;
        }

        for (int i = 0; i < testCase; i++) {
            int rank = 1;

            for (int j = 0; j < testCase; j++) {
                if (i == j) {
                    continue;
                }

                if (spec[i][0] < spec[j][0] && spec[i][1] < spec[j][1]) {
                    rank++;
                }
            }

            sb.append(rank).append(" ");
        }

        System.out.println(sb);
    }
}
