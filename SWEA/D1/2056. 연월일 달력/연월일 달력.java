import java.io.*;
import java.time.LocalDate;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            sb = new StringBuilder();
            sb.append("#").append(i).append(" ");

            String date = br.readLine();

            String year = date.substring(0, 4);
            String month = date.substring(4, 6);
            String day = date.substring(6, 8);

            try {
                LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

                sb.append(year).append("/").append(month).append("/").append(day);
                System.out.println(sb);
            } catch (Exception e) {
                sb.append(-1);
                System.out.println(sb);
            }
        }
    }
}
