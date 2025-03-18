import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> deck1 = new ArrayDeque(Arrays.asList(cards1));
        ArrayDeque<String> deck2 = new ArrayDeque(Arrays.asList(cards2));
        
        for (String target : goal) {
            if (!deck1.isEmpty() && deck1.peek().equals(target)) {
                deck1.poll();
            } else if (!deck2.isEmpty() && deck2.peek().equals(target)) {
                deck2.poll();
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}