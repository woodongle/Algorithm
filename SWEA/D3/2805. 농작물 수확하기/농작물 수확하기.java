import java.io.*;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");

			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];

			for (int i = 0; i < N; i++) {
				String line = br.readLine();

				for (int j = 0; j < N; j++) {
					farm[i][j] = line.charAt(j) - '0';
				}
			}

			
			int result = 0;
			int center = N / 2;
			int startCol = N / 2;
			int endCol = N / 2;
			
			for (int row = 0; row < N; row++) {
				for (int col = startCol; col <= endCol; col++) {
					result += farm[row][col];
				}
				
				if (row < center) {
					startCol--;
					endCol++;
				} else {
					startCol++;
					endCol--;
				}
			}
			
			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}
}
