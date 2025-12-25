import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        int index = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(String.valueOf(c), index++);
        }
        
        List<Integer> result = new ArrayList<>();
        String w = "";
        
        for (String s : msg.split("")) {
            if (dictionary.containsKey(w + s)) {
                w += s;
                continue;
            }
            
            result.add(dictionary.get(w));
            dictionary.put(w + s, index++);
            w = s;
        }
        
        if (w.length() > 0) {
            result.add(dictionary.get(w));
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}