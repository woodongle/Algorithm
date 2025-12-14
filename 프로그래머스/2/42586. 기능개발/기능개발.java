import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] daysLeft = new int[progresses.length];
        for (int i = 0; i < daysLeft.length; i++) {
            daysLeft[i] = (int) Math.ceil((100.00 - progresses[i]) / speeds[i]);
        }
        
        int count = 0;
        int maxDay = daysLeft[0];
        
        for (int i = 0; i < progresses.length; i++) {
            if (daysLeft[i] <= maxDay) {
                count++;
            } else {
                deque.addLast(count);
                count = 1;
                maxDay = daysLeft[i];
            }
        }
        
        deque.addLast(count);
        return deque.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}