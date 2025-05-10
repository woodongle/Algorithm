import java.io.*;
import java.util.*;

class Main {
	
	private static int[][] board;
	private static int m, n;
	private static Queue<int[]> queue = new LinkedList<>();
	
	private static int[] rowDirection = {-1, 0, 1, 0};
	private static int[] colDirection = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		
		boolean hasUnripened = false;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				int number = Integer.parseInt(st.nextToken());
				
				board[i][j] = number;
				
				if (number == 1) {
					queue.offer(new int[] {i, j});
				} else if (number == 0) {
					hasUnripened = true;
				}
			}
		}
		
		if (!hasUnripened) {
			System.out.println(0);
			return;
		}
		
		int days = bfs();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(days - 1);
	}
	
	private static int bfs() {
		int days = 0;
		
		while (!queue.isEmpty()) {
			for (int i = 0; i < queue.size(); i++) {
				int[] current = queue.poll();
				int currentRow = current[0];
				int currentCol = current[1];
				
				for (int j = 0; j < 4; j++) {
					int nextRow = currentRow + rowDirection[j];
					int nextCol = currentCol + colDirection[j];
					
					if (nextRow >= 0 && nextRow < n && 
						nextCol >= 0 && nextCol < m && 
						board[nextRow][nextCol] == 0) {
						
						board[nextRow][nextCol] = board[currentRow][currentCol] + 1;
						queue.offer(new int[] {nextRow, nextCol});
					}
				}
				
				days = Math.max(days, board[currentRow][currentCol]);
			}
		}
		
		return days;
	}
}
