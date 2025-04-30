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
			int M = Integer.parseInt(st.nextToken());
			int[] Ai = new int[N];
			int[] Bj = new int[M];
			
			makeArr(br, N, Ai);
			makeArr(br, M, Bj);
			
			int min = Math.min(N, M);
			int max = Math.max(N, M);
			
			int maxResult = 0;
			for (int i = 0; i < max - min + 1; i++) {
				int sum = 0;
				
				for (int j = 0; j < min; j++) {
					if (Ai.length < Bj.length) {
						sum += (Ai[j] * Bj[i + j]);
					} else {
						sum += (Ai[i + j] * Bj[j]);
					}
				}
				
				maxResult = Math.max(sum, maxResult);
			}
			
			sb.append(maxResult).append("\n");
		}

		System.out.println(sb);
	}
	
	private static void makeArr(BufferedReader br, int length, int[] arr) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
}
