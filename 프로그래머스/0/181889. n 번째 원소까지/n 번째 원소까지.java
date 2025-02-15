import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] newNumList = new int[n];
        for (int i = 0; i < n; i++) {
            newNumList[i] = num_list[i];
        }

        return newNumList;
    }
}