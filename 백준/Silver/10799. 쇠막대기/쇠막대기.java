import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);

            if (current == '(') {
                stack.push(current);
                continue;
            }

            stack.pop();
            char prev = line.charAt(i - 1);

            if (prev == '(') {
                result += stack.size();
            } else if (prev == ')') {
                result++;
            }
        }

        System.out.println(result);
    }
}