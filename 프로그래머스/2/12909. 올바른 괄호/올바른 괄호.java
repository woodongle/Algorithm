import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        String[] brackets = s.split("");
        int openBracketCount = 0;
        int closeBracketCount = 0;
       
        if (brackets[0].equals(")")) {
            answer = false;
            return answer;
        }
        
        for (String bracket : brackets) {
            if (openBracketCount < closeBracketCount) {
                answer = false;
                break;
            }
            
            if (bracket.equals("(")) {
                openBracketCount++;
                continue;
            }
            
            if (bracket.equals(")")) {
                closeBracketCount++;
            }
        }
        
        if (openBracketCount - closeBracketCount > 1) {
            answer = false;
            return answer;
        }
        
        if (openBracketCount != closeBracketCount) {
            answer = false;
        }

        return answer;
    }
}