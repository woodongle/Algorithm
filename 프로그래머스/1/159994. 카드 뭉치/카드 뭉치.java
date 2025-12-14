import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> deque1 = new ArrayDeque<>();
        ArrayDeque<String> deque2 = new ArrayDeque<>();
        
        for (String s : cards1) {
            deque1.addLast(s);
        }
        
        for (String s : cards2) {
            deque2.addLast(s);
        }
        
        for (String word : goal) {
            if (word.equals(deque1.peek())) {
                deque1.pollFirst();
                continue;
            }
            
            if (word.equals(deque2.peek())) {
                deque2.pollFirst();
                continue;
            }
            
            return "No";
        }
        
        return "Yes";
    }
}