import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int number1 = Integer.parseInt(st.nextToken());
        int number2 = Integer.parseInt(st.nextToken());
        int min = Math.min(number1, number2);
        int GCF = 0;
        for (int i = 1; i <= min; i++) {
            if (number1 % i == 0 && number2 % i == 0) {
                GCF = i;
            }
        }

        System.out.println(GCF);

        int LCM = number1 * number2 / GCF;
        System.out.println(LCM);
    }
}
