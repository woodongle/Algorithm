import java.io.*;
import java.time.LocalDate;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            sb.append("#").append(i).append(" ");

            String date = br.readLine();

            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(4, 6));
            int day = Integer.parseInt(date.substring(6, 8));

            try {
                LocalDate.of(year, month, day);

                sb.append(String.format("%04d/%02d/%02d", year, month, day));
            } catch (Exception e) {
                sb.append(-1);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
