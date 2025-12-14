import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
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
                list.add(count);
                count = 1;
                maxDay = daysLeft[i];
            }
        }
        
        list.add(count);
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}