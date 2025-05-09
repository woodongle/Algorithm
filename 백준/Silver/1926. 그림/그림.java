import java.io.*;
import java.util.*;

class Main {
	
	private static int[][] board;
	private static int n, m;
	private static boolean[][] visited;
	private static int[] rowDirection = {-1, 0, 1, 0};
	private static int[] colDirection = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int totalCount = 0;
		int maxCount = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 1 && !visited[i][j]) {
					totalCount++;
					
					int currentCount = bfs(i, j);
					maxCount = Math.max(maxCount, currentCount);
				}
			}
		}
		
		System.out.println(totalCount);
		System.out.println(maxCount);
	}

	private static int bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {row, col});
		visited[row][col] = true;
		
		int currentCount = 0;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentRow = current[0];
			int currentCol = current[1];
			
			currentCount++;
			
			for (int i = 0; i < 4; i++) {
				int nextRow = currentRow + rowDirection[i];
				int nextCol = currentCol + colDirection[i];
				
				if (nextRow >= 0 && nextRow < n && 
					nextCol >= 0 && nextCol < m && 
					board[nextRow][nextCol] == 1 && 
					!visited[nextRow][nextCol]) {
					
					visited[nextRow][nextCol] = true;
					queue.offer(new int[] {nextRow, nextCol});
				}
			}
		}
		
		return currentCount;
	}
}
