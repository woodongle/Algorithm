import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int testCase = 1; testCase <= T; testCase++) {
            int n = Integer.parseInt(br.readLine());
            
            Map<String, Integer> map = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                
                String s = st.nextToken();
                String value = st.nextToken();
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
            
            if (map.size() == 1) {
                sb.append(n).append('\n');
                continue;
            }
            
            int count = 1;
            for (int value : map.values()) {
                count *= (value +1);
            }
            
            sb.append(count - 1).append('\n');
        }
        
        System.out.println(sb);
    }
}