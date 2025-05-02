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
			int t1 = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int tSum = 0;
			int mSum = 0;
			
			tSum = t1 + t2;
			mSum = m1 + m2;
			
			if (mSum >= 60) {
				mSum -= 60;
				tSum += 1;
			}
			
			tSum = (tSum - 1) % 12 + 1;
			
			sb.append(tSum).append(" ").append(mSum).append("\n");
		}

		System.out.println(sb);
	}
}
