import java.io.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 1; i <= number; i++) {
            result += i;
        }

        System.out.println(result);
    }
}
