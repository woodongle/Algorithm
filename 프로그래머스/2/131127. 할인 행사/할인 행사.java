import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        
        int count = 0;
        A:for (int i = 0; i <= discount.length - 10; i++) {
            for (int m = 0; m < want.length; m++) {
                map.put(want[m], number[m]);
            }
            
            for (int j = i; j < i + 10; j++) {
                String goods = discount[j];
                
                if (!map.containsKey(goods)) {
                    continue;
                }
                
                map.put(goods, map.get(goods) - 1);
            }
            
            for (String key : map.keySet()) {
                if (map.get(key) > 0) {
                    continue A;
                }
            }
            
            count++;
        }
        
        return count;
    }
}