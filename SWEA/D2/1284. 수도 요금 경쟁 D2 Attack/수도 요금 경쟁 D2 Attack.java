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
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			// A사
			int resultA = W * P;
			
			// B사
			int resultB = 0;
			if (W <= R) {
				resultB = Q;
			} else {
				resultB = Q + ((W - R) * S);
			}
			
			sb.append(Math.min(resultA, resultB)).append("\n");
		}

		System.out.println(sb);
	}
}
