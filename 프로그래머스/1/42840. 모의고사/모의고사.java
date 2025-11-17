import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] arr = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] scores = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (answers[i] == arr[j][i % arr[j].length]) {
                    scores[j]++;
                }
            }
        }
        
        int maxScore = Arrays.stream(scores)
            .max()
            .getAsInt();
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                result.add(i + 1);
            }
        }
        
        int[] answer = result.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
        return answer;
    }
}