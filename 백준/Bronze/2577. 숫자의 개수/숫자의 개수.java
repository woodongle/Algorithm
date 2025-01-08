import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String[] result = String.valueOf(A * B * C).split("");

        for (int i = 0; i <= 9; i++) {
            int count = 0;

            for (String number : result) {
                if (Integer.parseInt(number) == i) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
