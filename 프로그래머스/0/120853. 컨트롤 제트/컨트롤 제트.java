import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Integer> stack = new Stack<>();
        
        for (String o : s.split(" ")) {
            if (o.equals("Z")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(o));
            }
        }
        
        int answer = 0;
        
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }
        
        return answer;
    }
}