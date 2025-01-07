import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = -1_000_000;
        int min = 1_000_000;
        int count = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            int number = Integer.parseInt(st.nextToken());

            if (max < number) {
                max = number;
            }

            if (min > number) {
                min = number;
            }
        }

        System.out.println(min + " " + max);
    }
}
