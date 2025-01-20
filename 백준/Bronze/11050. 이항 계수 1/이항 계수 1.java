import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(binomialCoefficient(N, K));
    }

    public static int binomialCoefficient(int n, int k) {
        if (k == 0 || n == k) {
            return 1;
        }

        return binomialCoefficient(n - 1, k) + binomialCoefficient(n - 1, k - 1);
    }
}
