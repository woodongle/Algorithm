import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append("\n");
			
			int currentLineLength = 0;

			int N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String C = st.nextToken();
				int K = Integer.parseInt(st.nextToken());

				for (int j = 0; j < K; j++) {
					sb.append(C);
					currentLineLength++;
					
					if (currentLineLength == 10) {
						sb.append("\n");
						currentLineLength = 0;
					}
				}
			}
			
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
