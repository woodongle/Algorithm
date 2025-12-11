import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> deleted = new Stack<>();
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];
        
        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        
        k++;
        
        for (String c : cmd) {
            if (c.startsWith("C")) {
                deleted.push(k);
                down[up[k]] = down[k];
                up[down[k]] = up[k];
                k = down[k] <= n ? down[k] : up[k];
            } else if (c.startsWith("Z")) {
                int pop = deleted.pop();
                down[up[pop]] = pop;
                up[down[pop]] = pop;
            } else {
                String[] split = c.split(" ");
                String command = split[0];
                int moveNum = Integer.parseInt(split[1]);
                
                for (int i = 0; i < moveNum; i++) {
                    k = command.equals("U") ? up[k] : down[k];
                }
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        for (int num : deleted) {
            answer[num - 1] = 'X';
        }
        
        return new String(answer);
    }
}