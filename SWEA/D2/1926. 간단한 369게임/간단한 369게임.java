import java.io.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            int count = count369(i);

            if (count > 0) {
                for (int j = 0; j < count; j++) {
                    sb.append("-");
                }

                sb.append(" ");
                continue;
            }

            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    public static int count369(int number) {
        int count = 0;

        while (number > 0) {
            int remainder = number % 10;

            if (remainder == 3 || remainder == 6 || remainder == 9) {
                count++;
            }

            number /= 10;
        }

        return count;
    }
}
