import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> cardQueue1 = createQueue(cards1);
        ArrayDeque<String> cardQueue2 = createQueue(cards2);
        ArrayDeque<String> goalQueue = createQueue(goal);
        
        while (!goalQueue.isEmpty()) {
            String answerCard = goalQueue.poll();
            
            if (!cardQueue1.isEmpty()) {
                String card1 = cardQueue1.poll();
                
                if (answerCard.equals(card1)) {
                    continue;
                } else {
                    cardQueue1.addFirst(card1);
                }
            }
            
            String card2 = "";
            if (!cardQueue2.isEmpty()) {
                card2 = cardQueue2.poll();
            }
            
            if (answerCard.equals(card2)) {
                continue;
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
    
    public ArrayDeque<String> createQueue(String[] arr) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        
        return queue;
    }
}