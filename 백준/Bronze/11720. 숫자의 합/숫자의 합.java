import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[] chArr = br.readLine().toCharArray();
		int[] arr = new int[N];
		int sum = 0;
		
		br.close();
		
		for (int i = 0; i < N; i++) {
			arr[i] = chArr[i] - 48;
			sum += arr[i];
		}
		
		System.out.println(sum);
		
	}
}