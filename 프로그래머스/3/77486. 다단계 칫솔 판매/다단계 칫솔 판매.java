import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> referralMap = new HashMap<>();
        Map<String, int[]> moneyMap = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            referralMap.put(enroll[i], referral[i]);
            moneyMap.put(enroll[i], new int[]{i, 0});
        }
        
        
        for (int i = 0; i < seller.length; i++) {
            String currentSeller = seller[i];
            int profit = amount[i] * 100;
            
            while (!currentSeller.equals("-") && profit > 0) {
                int referralMoney = profit / 10;
                int mineMoney = profit - referralMoney;
                
                moneyMap.get(currentSeller)[1] += mineMoney;
                
                currentSeller = referralMap.get(currentSeller);
                profit = referralMoney;
            }
        }
        
        int[] answer = new int[enroll.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = moneyMap.get(enroll[i])[1];
        }

        return answer;
    }
}