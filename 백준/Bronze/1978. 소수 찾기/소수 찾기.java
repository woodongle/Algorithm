import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        br.readLine();
        
        boolean[] bool = new boolean[1001];
        bool[1] = true;
        
        for (int i = 2; i*i < bool.length; i++) {
        	if (!bool[i]) {
        		for (int j = i*i; j < bool.length; j += i) {
        			bool[j] = true;
        		}
        	}
        }
        
        int count = 0;
        String[] arr = br.readLine().split(" ");
        
        for (int i = 0; i < arr.length; i++) {
        	if (!bool[Integer.parseInt(arr[i])]) {
        		count++;
        	}
        }
        
        System.out.println(count);
	}
}