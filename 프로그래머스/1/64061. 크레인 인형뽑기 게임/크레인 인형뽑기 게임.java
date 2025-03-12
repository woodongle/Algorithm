import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        Stack<Integer> luckyStack = new Stack<>();
        int count = 0;
        
        for (int move : moves) {
            int col = move - 1;
            
            for (int row = 0; row < board.length; row++) {
                int luckyNumber = board[row][col];
                
                if (luckyNumber != 0) {
                    board[row][col] = 0;
                    
                    if (!luckyStack.isEmpty() && luckyStack.peek() == luckyNumber) {
                        luckyStack.pop();
                        count += 2;
                    } else {
                        luckyStack.push(luckyNumber);
                        board[row][col] = 0;
                    }
                    
                    break;
                }
            }
        }
        
        return count;
    }
}