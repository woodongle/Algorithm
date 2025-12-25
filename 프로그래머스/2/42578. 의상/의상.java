import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] s : clothes) {
            map.put(s[1], map.getOrDefault(s[1], 1) + 1);
        }
        
        int answer = 1;
        for (String s : map.keySet()) {
            answer *= map.get(s);
        }
        
        return answer - 1;
    }
}