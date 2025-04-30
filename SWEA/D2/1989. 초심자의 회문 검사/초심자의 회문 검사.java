import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			String word = br.readLine();
			int start = 0;
			int end = word.length() - 1;
			boolean isPalindrome = true;
			
			while (start <= end) {
				if (word.charAt(start) != word.charAt(end)) {
					isPalindrome = false;
					break;
				}
				
				start++;
				end--;
			}
			
			
			sb.append(isPalindrome ? 1 : 0).append("\n");
		}

		System.out.println(sb);
	}
}
