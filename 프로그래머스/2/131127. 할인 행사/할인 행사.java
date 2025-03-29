import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wantMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> discountMap = new HashMap<>();

            for (int j = 0; j < 10; j++) {
                String discountProduct = discount[i + j];

                discountMap.put(discountProduct, discountMap.getOrDefault(discountProduct, 0) + 1);
            }

            if (wantMap.equals(discountMap)) {
                count++;
            }
        }

        return count;
    }
}