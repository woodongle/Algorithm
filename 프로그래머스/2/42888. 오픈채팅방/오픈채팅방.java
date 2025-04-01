import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> nicknames = new HashMap<>();

        for (String history : record) {
            String[] parts = history.split(" ");
            String command = parts[0];
            String userId = parts[1];

            if (command.equals("Enter") || command.equals("Change")) {
                String nickname = parts[2];
                nicknames.put(userId, nickname);
            }
        }

        ArrayList<String> messages = new ArrayList<>();

        for (String history : record) {
            String[] parts = history.split(" ");
            String command = parts[0];
            String userId = parts[1];

            if (command.equals("Enter")) {
                messages.add(nicknames.get(userId) + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                messages.add(nicknames.get(userId) + "님이 나갔습니다.");
            }
        }

        return messages.toArray(new String[0]);
    }
}