import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int start = 200_000_000;
        int end = 0;
        
        for (int stone : stones) {
            start = Math.min(stone, start);
            end = Math.max(stone, end);
        }
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (binarySearch(stones, mid, k)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return answer;
    }
    
    static boolean binarySearch(int[] stones, int mid, int k) {
        int count = 0;
        
        for (int stone : stones) {
            if (stone < mid) {
                count++;

                if (count == k) {
                    return false;
                }
            } else {
                count = 0;
            }
        }
        
        return true;
    }
}