import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> userIndexMap = new HashMap<>();
        Map<String, Set<String>> reportedMap = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++) {
            String reportedUserId = id_list[i];
            userIndexMap.put(reportedUserId, i);
            reportedMap.put(reportedUserId, new HashSet<>());
        }
        
        for (String s : report) {
            String[] split = s.split(" ");
            String reportUserId = split[0];
            String reportedUserId = split[1];
            
            reportedMap.get(reportedUserId).add(reportUserId);
        }
        
        int[] answer = new int[id_list.length];
        for (String reportedUserId : id_list) {
            Set<String> reportUserIds = reportedMap.get(reportedUserId);
            
            if (reportUserIds.size() < k) {
                continue;
            }
            
            for (String reportUserId : reportUserIds) {
                int index = userIndexMap.get(reportUserId);
                answer[index]++;
            }
        }
        
        return answer;
    }
}