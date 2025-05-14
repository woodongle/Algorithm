import java.util.*;
import java.io.*;

class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] magnetics = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < N; j++) {
					magnetics[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int deadlockCount = 0;
			
			for (int i = 0; i < N; i++) {
				boolean isBlueMagnetActive = false;
				
				for (int j = 0; j < N; j++) {
					if (magnetics[j][i] == 1) {
						isBlueMagnetActive = true;
					} else if (magnetics[j][i] == 2) {
						if (isBlueMagnetActive) {
							deadlockCount++;
							isBlueMagnetActive = false;
						}
					}
				}
			}
			
			sb.append(deadlockCount).append("\n");
		}

		System.out.println(sb);
	}
}
