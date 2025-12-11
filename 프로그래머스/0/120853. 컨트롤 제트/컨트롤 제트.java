class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] split = s.split(" ");
        int prev = Integer.parseInt(split[0]);
        answer += prev;
        
        for (int i = 1; i < split.length; i++) {
            String current = split[i];
            if (current.equals("Z")) {
                answer -= prev;
            } else {
                answer += Integer.parseInt(current);
                prev = Integer.parseInt(current);
            }
        }
        
        return answer;
    }
}