import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 31);
		map.put(2, 28);
		map.put(3, 31);
		map.put(4, 30);
		map.put(5, 31);
		map.put(6, 30);
		map.put(7, 31);
		map.put(8, 31);
		map.put(9, 30);
		map.put(10, 31);
		map.put(11, 30);
		map.put(12, 31);
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m1 = Integer.parseInt(st.nextToken());
			int d1 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken());
			int result = 0;
			
			for (int i = m1; i <= m2; i++) {
				if (m1 == m2) {
					result = d1 + d2 - 1;
					break;
				}
				
				if (i == m1) {
					int lastDay = map.get(m1);
					result += lastDay - d1 + 1;
					continue;
				} else if (i < m2) {
					result += map.get(i);
				} else {
					result += d2;
				}
				
			}
			
			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}
}
