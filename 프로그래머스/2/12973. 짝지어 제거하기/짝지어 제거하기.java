import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> c = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (c.size() == 0) {
                c.push(s.charAt(i));
                continue;
            }
            
            if (c.peek().equals(s.charAt(i))) {
                c.pop();
                continue;
            }
            
            c.push(s.charAt(i));
        }
        
        System.out.println(c);

        return c.size() == 0 ? 1 : 0;
    }
}