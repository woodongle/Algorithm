import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] alphabets = "abcdefghijklmnopqrstuvwxyz".split("");

        int[] indexNumbers = new int[26];
        for (int i = 0; i < indexNumbers.length; i++) {
            indexNumbers[i] = -1;
        }

        String word = br.readLine();
        String[] words = word.split("");
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < alphabets.length; j++) {
                if (words[i].equals(alphabets[j])) {
                    indexNumbers[j] = word.indexOf(words[i]);
                }
            }
        }
        for (int indexNumber : indexNumbers) {
            sb.append(indexNumber).append(" ");
        }

        System.out.println(sb);
    }
}
