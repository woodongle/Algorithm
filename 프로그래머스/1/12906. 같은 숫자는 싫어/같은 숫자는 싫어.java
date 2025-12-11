import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            int prevNum = list.get(list.size() - 1);
            int currentNum = arr[i];
            
            if (prevNum != currentNum) {
                list.add(currentNum);
            }
        }
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}