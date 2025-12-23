import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        for (String s : report) {
            String[] split = s.split(" ");
            String reportUserId = split[0];
            String reportedUserId = split[1];
            
            if (!reportMap.containsKey(reportUserId)) {
                reportMap.put(reportUserId, new HashSet<>());
            }
            reportMap.get(reportUserId).add(reportedUserId);
        }
        
        Map<String, Integer> totalReportedCountMap = new HashMap<>();
        for (String reportUserId : reportMap.keySet()) {
            Set<String> reportedUserIdSet = reportMap.get(reportUserId);
            
            for (String reportedUserId : reportedUserIdSet) {
                totalReportedCountMap.put(reportedUserId, 
                                         totalReportedCountMap.getOrDefault(reportedUserId, 0) + 1);
            }
        }
        
        List<String> reportedUserIds = new ArrayList<>();
        for (String reportedUserId : totalReportedCountMap.keySet()) {
            if (totalReportedCountMap.get(reportedUserId) >= k) {
                reportedUserIds.add(reportedUserId);
            }
        }
        
        Map<String, Integer> userMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            userMap.put(id_list[i], i);
        }
        
        int[] answer = new int[id_list.length];
        for (String reportUserId : reportMap.keySet()) {
            Set<String> reportedUserIdSet = reportMap.get(reportUserId);
            
            for (String reportedUserId : reportedUserIds) {
                int index = userMap.get(reportUserId);
                
                if (reportedUserIdSet.contains(reportedUserId)) {
                    answer[index]++;
                }
            }
        }
        
        return answer;
    }
}