import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] str = br.readLine().split("");

            if (str[0].equals("0")) {
                return;
            }

            List<String> palindrome = new ArrayList<>(List.of(str));
            List<String> reversePalindrome = new ArrayList<>(List.of(str));
            Collections.reverse(reversePalindrome);

            if (palindrome.equals(reversePalindrome)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }
    }
}
