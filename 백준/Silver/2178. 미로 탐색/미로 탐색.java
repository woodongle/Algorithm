import java.io.*;
import java.util.*;

class Main {
	
	private static int[][] board;
	private static int n, m;
	private static int[][] visited;
	private static int[] rowDirection = {-1, 0, 1, 0};
	private static int[] colDirection = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		visited = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < m; j++) {
				board[i][j] = line.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
		
		System.out.println(visited[n - 1][m - 1]);
	}
	
	private static void bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {row, col});
		visited[row][col] = 1;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentRow = current[0];
			int currentCol = current[1];
			
			if (currentRow == n - 1 && currentCol == m - 1) {
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nextRow = currentRow + rowDirection[i];
				int nextCol = currentCol + colDirection[i];
				
				if (nextRow >= 0 && nextRow < n && 
					nextCol >= 0 && nextCol < m && 
					board[nextRow][nextCol] == 1 &&
					visited[nextRow][nextCol] == 0) {
					
					queue.offer(new int[] {nextRow, nextCol});
					visited[nextRow][nextCol] = visited[currentRow][currentCol] + 1;
				}
			}
		}
	}
}
