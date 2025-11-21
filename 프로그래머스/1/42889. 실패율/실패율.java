import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stageUserCounts = new int[N + 2];

        for (int stage : stages) {
            stageUserCounts[stage]++;
        }

        HashMap<Integer, Double> failRateMap = new HashMap<>();
        int totalUserCount = stages.length;

        for (int i = 1; i <= N; i++) {
            int stageUserCount = stageUserCounts[i];

            if (stageUserCount == 0) {
                failRateMap.put(i, 0.0);
            } else {
                failRateMap.put(i, (double) stageUserCount / totalUserCount);
                totalUserCount -= stageUserCount;
            }
        }

        ArrayList<Integer> keys = new ArrayList<>(failRateMap.keySet());
        keys.sort((k1, k2) -> {
            int compare = failRateMap.get(k2).compareTo(failRateMap.get(k1));

            if (compare == 0) {
                return k1.compareTo(k2);
            }

            return compare;
        });

        return keys.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}