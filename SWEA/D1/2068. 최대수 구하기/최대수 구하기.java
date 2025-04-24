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
            sb.append("#").append(i).append(" ");

            int[] numbers = new int[10];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(numbers);
            sb.append(numbers[numbers.length - 1]);

            System.out.println(sb);
        }
    }
}
