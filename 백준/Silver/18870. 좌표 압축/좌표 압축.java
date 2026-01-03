import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        
        int[] arr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int[] cloneArr = arr.clone();
        Arrays.sort(cloneArr);
        
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        
        for (int num : cloneArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(rankMap.get(num)).append(" ");
        }
        
        System.out.println(sb);
    }
}