import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#").append(testCase).append(" ");

			int N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] numbers = new int[100];
			
			for (int i = 0; i < 100; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				Arrays.sort(numbers);
				
				if (numbers[99] - numbers[0] <= 1) {
					break;
				}
				
				numbers[0]++;
				numbers[99]--;	
			}
			
			Arrays.sort(numbers);
			
			sb.append(numbers[99] - numbers[0]).append("\n");
		}
		
		System.out.println(sb);
	}
}
