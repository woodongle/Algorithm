import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String initialString = br.readLine();
        List<Character> results = new LinkedList<>();
        
        for (char c : initialString.toCharArray()) {
            results.add(c);
        }
        
        ListIterator<Character> cursor = results.listIterator();
        while (cursor.hasNext()) {
            cursor.next();
        }
        
        int M = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < M; i++) {
            String commandLine = br.readLine();
            char command = commandLine.charAt(0);
            
            if (command == 'L') {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                }
                
                continue;
            } else if (command == 'D') {
                if (cursor.hasNext()) {
                    cursor.next();
                }
            } else if (command == 'B') {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            } else {
                char value = commandLine.charAt(2);
                cursor.add(value);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : results) {
            sb.append(c);
        }
        
        System.out.println(sb);
    }
}