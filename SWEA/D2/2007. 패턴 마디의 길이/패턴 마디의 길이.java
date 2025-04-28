import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			sb.append("#").append(i).append(" ");

			String word = br.readLine();
			int count = 0;
			
			for (int j = 1; j <= 10; j++) {
				String pattern = word.substring(0, j);
				String nextPattern = word.substring(pattern.length(), pattern.length() * 2);
				
				if (pattern.equals(nextPattern)) {
					count = pattern.length();
					break;
				}
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}
}
