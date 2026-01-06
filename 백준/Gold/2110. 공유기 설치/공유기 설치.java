import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int C = Integer.parseInt(split[1]);
        int[] wifi = new int[N];
        
        for (int i = 0; i < N; i++) {
            wifi[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(wifi);
        
        int start = 1;
        int end = wifi[N - 1] - wifi[0];
        int answer = 0;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (binarySearch(wifi, C, mid)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
    
    static boolean binarySearch(int[] wifi, int C, int mid) {
        int prevX = wifi[0];
        int count = 1;
        
        for (int i = 1; i < wifi.length; i++) {
            if (wifi[i] - prevX >= mid) {
                count++;
                prevX = wifi[i];

                if (count == C) {
                    return true;
                }
            }
        }
        
        return false;
    }
}