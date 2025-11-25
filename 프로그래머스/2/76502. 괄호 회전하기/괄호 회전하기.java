import java.util.*;

class Solution {
    public int solution(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        int sLength = s.length();
        s += s;
        int answer = 0;
        
        A:for (int i = 0; i < sLength; i++) {
            Stack<Character> stack = new Stack<>();
            
            for (int j = i; j < sLength + i; j++) {
               char c = s.charAt(j);
               
               if (!map.containsKey(c)) {
                   stack.push(c);
               } else {
                   if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                       stack.pop();
                   } else {
                       continue A;
                   }
               }
           }
            
            if (stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}