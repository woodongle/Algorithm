import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().trim().split(" ");

        if (str[0].isBlank()) {
            System.out.println(0);
        } else {
            System.out.println(str.length);
        }
    }
}
