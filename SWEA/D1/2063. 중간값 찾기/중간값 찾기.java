import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        String[] split = br.readLine().split(" ");
        HashSet<String> set = new HashSet<>(Arrays.asList(split));
        List<String> numbers = new ArrayList<>(set);

        System.out.println(numbers.get(numbers.size() / 2 + 1));
    }
}
