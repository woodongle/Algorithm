import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long result = 0;

        for (int i = 0; i < N; i++) {
            long number = i;
            long sum = 0;

            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if (i + sum == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
