import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] number1 = {1, 2, 3, 4, 5};
        int[] number2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] number3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[3];

        scores[0] = grade(answers, number1);
        scores[1] = grade(answers, number2);
        scores[2] = grade(answers, number3);

        int maxNumber = findMaxNumber(scores);

        List<Integer> winners = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (maxNumber == scores[i]) {
                winners.add(i + 1);
            }
        }

        int[] answer = new int[winners.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = winners.get(i);
        }

        return answer;
    }
    
    public static int grade(int[] answers, int[] numbers) {
        int count = 0;

        for (int i = 0; i < answers.length; i++) {
            if (numbers[i % numbers.length] == answers[i]) {
                count++;
            }
        }

        return count;
    }
    
    public static int findMaxNumber(int[] scores) {
        int max = 0;

        for (int score : scores) {
            if (max < score) {
                max = score;
            }
        }

        return max;
    }
}