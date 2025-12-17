import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        for (String s : record) {
            String[] split = s.split(" ");
            String command = split[0];
            
            if (command.equals("Leave")) {
                continue;
            }
            
            String userId = split[1];
            String nickname = split[2];
            
            map.put(userId, nickname);
        }
        
        List<String> list = new ArrayList<>();
        for (String s : record) {
            String[] split = s.split(" ");
            String command = split[0];
            
            if (command.equals("Change")) {
                continue;
            }
            
            String userId = split[1];
            
            if (command.equals("Enter")) {
                list.add(map.get(userId) + "님이 들어왔습니다.");
            } else {
                list.add(map.get(userId) + "님이 나갔습니다.");
            }
        }
        
        return list.toArray(new String[0]);
    }
}