import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answers) {
        // 각 수포자의 패턴을 2차원 배열에 초기화 한다.
        // 정답이 있는 배열과 2차원 배열의 행들을 하나의 열씩 비교한다.
        // 비교하여 맞으면 카운트를 1 증가한다.
        // 카운트가 가장 높은 수포자의 번호를 반환
        // 카운트가 동일한 경우 번호의 오름차순으로 반환
        
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