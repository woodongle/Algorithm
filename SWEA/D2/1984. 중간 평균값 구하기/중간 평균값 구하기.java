import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] numbers = new int[10];
			for (int i = 0; i < 10; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(numbers);
			
			int sum = 0;
			numbers[0] = 0;
			numbers[9] = 0;
			for (int i = 1; i < 9; i++) {
				sum += numbers[i];
			}
			
			sb.append(Math.round(sum / 8.0)).append("\n");
		}

		System.out.println(sb);
	}
}
