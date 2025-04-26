import java.io.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            if (isContains(i)) {
                String[] numberParts = String.valueOf(i).split("");

                int sum = 0;
                for (String number : numberParts) {
                    if (isContains(number)) {
                        sum++;
                    }
                }

                for (int j = 0; j < sum; j++) {
                    sb.append("-");
                }

                sb.append(" ");
                continue;
            }

            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    public static boolean isContains(int i) {
        return String.valueOf(i).contains("3") || String.valueOf(i).contains("6") || String.valueOf(i).contains("9");
    }

    public static boolean isContains(String number) {
        return String.valueOf(number).contains("3") || String.valueOf(number).contains("6") || String.valueOf(number).contains("9");
    }
}
