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
			List<String> list = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
			HashSet<String> set = new HashSet<>();
			
			int count = 0;
			int temp = N;
			
			while (true) {
				count++;
				String[] split = String.valueOf(temp).split("");
				
				for (String s : split) {
					set.add(s);
				}
				
				if (set.containsAll(list)) {
					break;
				} else {
					temp += N;
				}
			}
			
			
			sb.append(count * N).append("\n");
		}

		System.out.println(sb);
	}
}
