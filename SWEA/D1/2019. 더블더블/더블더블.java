import java.io.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());
        int result = 1;

        sb.append(1).append(" ");
        for (int i = 1; i <= number; i++) {
            result *= 2;
            sb.append(result).append(" ");
        }

        System.out.println(sb);
    }
}
