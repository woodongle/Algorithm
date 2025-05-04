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
			int[] buildings = new int[N];

			for (int i = 0; i < N; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}

			int result = 0;
			for (int i = 2; i < N - 2; i++) {
				int currentBuilding = buildings[i];
				int leftMax = Math.max(buildings[i - 2], buildings[i - 1]);
				int rightMax = Math.max(buildings[i + 1], buildings[i + 2]);
				
				if (currentBuilding <= leftMax || currentBuilding <= rightMax) {
					result += 0;
					continue;
				}
				
				result += (currentBuilding - Math.max(leftMax, rightMax));
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}
}
