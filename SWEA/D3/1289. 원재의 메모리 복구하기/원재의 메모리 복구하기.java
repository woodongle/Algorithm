import java.util.*;
import java.io.*;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");

			String originNumber = br.readLine();
			int count = 0;
			int prev = 0;

			for (int i = 0; i < originNumber.length(); i++) {
				int number = originNumber.charAt(i) - '0';
				
				if (prev == number) {
					continue;
				}
				
				prev = number;
				count++;
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}
}
