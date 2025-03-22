import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> completionMap = new HashMap<>();
        for (String name : completion) {
            completionMap.put(name, completionMap.getOrDefault(name, 0) + 1);
        }
        
        for (String name : participant) {
            if (completionMap.getOrDefault(name, 0) == 0) {
                return name;
            }
            
            completionMap.put(name, completionMap.get(name) - 1);
        }
        
        return "";
    }
}