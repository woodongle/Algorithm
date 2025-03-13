import java.util.*;
import java.io.*;

class Solution {
    
    private static final Map<Character, Character> map = new HashMap<>();
    
    public static int solution(String s) {
        int count = 0;
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i) + s.substring(0, i);
            
            if (isValid(str)) {
                count++;
            }
        }

        return count;
    }

    static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != map.get(ch)) {
                    return false;
                }
                
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        
        return stack.isEmpty();
    }
}