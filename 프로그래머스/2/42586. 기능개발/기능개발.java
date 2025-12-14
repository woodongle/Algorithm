import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            deque.addLast(new int[]{progresses[i], speeds[i]});
        }

        List<Integer> list = new ArrayList<>();
        while (!deque.isEmpty()) {
            for (int i = 0; i < deque.size(); i++) {
                int[] poll = deque.pollFirst();
                deque.addLast(new int[]{poll[0] + poll[1], poll[1]});
            }

            int count = 0;
            while (!deque.isEmpty()) {
                if (deque.peek()[0] < 100) {
                    break;
                }

                deque.pollFirst();
                count++;
            }

            if (count > 0) {
                list.add(count);
            }
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}