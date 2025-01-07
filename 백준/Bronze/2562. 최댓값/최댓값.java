import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int count = 0;

        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 1; i <= 9; i++) {
            int number = Integer.parseInt(br.readLine());
            numbers.put(number, i);

            if (max < number) {
                max = number;
            }
        }

        System.out.println(max);
        System.out.println(numbers.get(max));
    }
}
