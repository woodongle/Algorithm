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
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] board = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int count = 0;
			
			// 가로줄 확인
			for (int i = 0; i < N; i++) {
				int consecutive = 0;
				
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 1) {
						consecutive++;
					} else {
						if (consecutive == K) {
							count++;
						}
						
						consecutive = 0;
					}
				}
				
				
				if (consecutive == K) {
					count++;
				}
			}
			
			// 세로줄 확인
			for (int i = 0; i < N; i++) {
				int consecutive = 0;
				
				for (int j = 0; j < N; j++) {
					if (board[j][i] == 1) {
						consecutive++;
					} else {
						if (consecutive == K) {
							count++;
						}
						
						consecutive = 0;
					}
				}
				
				if (consecutive == K) {
					count++;
				}
			}
			
			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}
}
