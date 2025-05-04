import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 10; i++) {
			int testCaseNumber = Integer.parseInt(br.readLine());
			sb.append("#").append(testCaseNumber).append(" ");
			
			int[][] numbers = new int[100][100];
			
			for (int row = 0; row < 100; row++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int col = 0; col < 100; col++) {
					numbers[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			
			for (int row = 0; row < 100; row++) {
				int rowSum = 0;
				int colSum = 0;
				
				for (int col = 0; col < 100; col++) {
					rowSum += numbers[row][col];
					colSum += numbers[col][row];
				}
				
				result = Math.max(result, Math.max(rowSum, colSum));
			}
			
			int leftDiagonalLineSum = 0;
			
			for (int j = 0; j < 100; j++) {
				leftDiagonalLineSum += numbers[j][j];				
			}
			
			int rightDiagonalLineSum = 0;
			
			for (int j = 99; j <= 0; j--) {
				rightDiagonalLineSum += numbers[j][j];				
			}
			
			result = Math.max(result, Math.max(leftDiagonalLineSum, rightDiagonalLineSum));
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}
}
