import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int caughtNumber = board[j][moves[i] - 1];
                board[j][moves[i] - 1] = 0;
                
                if (caughtNumber == 0) {
                    continue;
                }
                
                if (!stack.isEmpty() && stack.peek() == caughtNumber) {
                    stack.pop();
                    answer+=2;
                } else {
                    stack.push(caughtNumber);
                }
                
                break;
            }
        }
        
        while(stack.size() > 1) {
            int popNumber = stack.pop();
            System.out.println(popNumber);
            
            if (stack.size() > 1 && popNumber == stack.peek()) {
                stack.pop();
                answer+=2;
            }
        }
        
        return answer;
    }
}