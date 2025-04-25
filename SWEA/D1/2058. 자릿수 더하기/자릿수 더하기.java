import java.io.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split("");
        int sum = 0;

        for (String s : split) {
            sum += Integer.parseInt(s);
        }

        System.out.println(sum);
    }
}
