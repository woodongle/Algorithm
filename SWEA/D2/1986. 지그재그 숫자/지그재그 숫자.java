import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");

			int N = Integer.parseInt(br.readLine());
			int result = 1;
			
			for (int i = 2; i <= N; i++) {
				if (i % 2 == 0) {
					result -= i;
				} else {
					result += i;
				}
			}
			
			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}
}
