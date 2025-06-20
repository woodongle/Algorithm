import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("push_front")) {
                int value = Integer.parseInt(st.nextToken());
                deque.offerFirst(value);
                continue;
            } else if (command.equals("push_back")) {
                int value = Integer.parseInt(st.nextToken());
                deque.offerLast(value);
                continue;
            } else if (command.equals("pop_front")) {
                if (deque.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(deque.pollFirst());
                }
            } else if (command.equals("pop_back")) {
                if (deque.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(deque.pollLast());
                }
            } else if (command.equals("size")) {
                sb.append(deque.size());
            } else if (command.equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            } else if (command.equals("front")) {
                if (deque.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(deque.peekFirst());
                }
            } else if (command.equals("back")) {
                if (deque.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(deque.peekLast());
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}