import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int K = Integer.parseInt(split[1]);
		int[] coins = new int[N];
		
		for (int i = N - 1; i >= 0; i--) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			int coin = coins[i];
			
			if (K % coin != K) {
				count += (K / coin);
				K %= coin;
			}
		}
		
		System.out.println(count);
	}
}
