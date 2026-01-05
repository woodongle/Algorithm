import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input1 = br.readLine().split(" ");
        int M = Integer.parseInt(input1[1]);
        int[] treeArr = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        
        int start = 0;
        int end = 1_000_000_000;
        int answer = 0;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (binarySearch(treeArr, M, mid)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
    
    static boolean binarySearch(int[] treeArr, int M, int mid) {
        int sum = 0;
        
        for (int i = 0; i < treeArr.length; i++) {
            if (treeArr[i] > mid) {
                sum += treeArr[i] - mid;
                
                if (sum >= M) {
                    return true;
                }
            }
        }
        
        return false;
    }
}