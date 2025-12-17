import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        Map<String, Integer> resultMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i <= discount.length - 10; i++) {
            for (int j = i; j < i + 10; j++) {
                String discountGoods = discount[j];
                
                resultMap.put(discountGoods, 
                              resultMap.getOrDefault(discountGoods, 0) + 1);
            }
            
            if (resultMap.equals(wantMap)) {
                count++;
            }
            
            resultMap.clear();
        }
        
        return count;
    }
}