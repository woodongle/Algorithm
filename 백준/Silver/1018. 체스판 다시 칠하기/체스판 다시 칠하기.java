import java.util.*;
import java.io.*;

public class Main {
	
	public static boolean[][] board;
	public static int min = 64;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < M; j++) {
				if (line.charAt(j) == 'W') {
					board[i][j] = true;
				}
			}
		}
		
		int row = N - 7;
		int col = M - 7;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				WB(i, j);
			}
		}
		
		System.out.println(min);
	}

	private static void WB(int rowStart, int colStart) {
		int rowEnd = rowStart + 8;
		int colEnd = colStart + 8;
		int count = 0;
		
		boolean WB = board[rowStart][colStart];
		
		for (int i = rowStart; i < rowEnd; i++) {
			for (int j = colStart; j < colEnd; j++) {
				
				if (board[i][j] != WB) {
					count++;
				}
				
				WB = !WB;
			}
			
			WB = !WB;
		}
		
		count = Math.min(count, 64 - count);
		
		min = Math.min(min, count);
	}
}
