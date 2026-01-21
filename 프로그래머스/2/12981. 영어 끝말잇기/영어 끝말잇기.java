import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        char prevChar = words[0].charAt(words[0].length() - 1);
        list.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            int currentNum = i % n + 1;
            int count = i / n + 1;
            char currentChar = word.charAt(0);
            
            if (list.contains(word)) {
                return new int[]{currentNum, count};
            }
            
            if (word.length() == 1) {
                return new int[]{currentNum, count};
            }
            
            if (prevChar != currentChar) {
                return new int[]{currentNum, count};
            }
            
            prevChar = word.charAt(word.length() - 1);
            list.add(word);
        }

        return new int[]{0, 0};
    }
}