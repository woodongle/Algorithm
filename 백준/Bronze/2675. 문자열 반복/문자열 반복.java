import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken());
            String[] S = st.nextToken().split("");

            for (String s : S) {
                sb.append(s.repeat(R));
            }

            System.out.println(sb);
        }
    }
}
