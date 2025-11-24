import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int answerSize = (int) (right - left + 1);
        int[] answer = new int[answerSize];
        
        for (int i = 0; i < answerSize; i++) {
            long index = left + i;
            
            int row = (int)(index / n);
            int col = (int)(index % n);
                
            answer[i] = Math.max(row + 1, col + 1);
        }
        
        return answer;
    }
}