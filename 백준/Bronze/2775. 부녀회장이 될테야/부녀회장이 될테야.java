import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int[][] arr = new int[15][15];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		make();
		
		for (int i = 1; i <= T; i++) {
			int K = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(arr[K][n]);
		}
	}
	
	public static void make() {
		for (int i = 0; i < 15; i++) {
			arr[i][1] = 1;
			arr[0][i] = i;
		}
		
		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
			}
		}
	}
}