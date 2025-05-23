import java.io.*;
import java.util.*;

public class Main {
	
	private static int row, col;
	private static int[][] board;
	private static boolean[][] visited;
	private static Deque<int[]> queue;
	
	private static int[] rowDirection = {-1, 0, 1, 0};
	private static int[] colDirection = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			board = new int[row][col];
			visited = new boolean[row][col];
			queue = new ArrayDeque<>();
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				board[r][c] = 1;
			}
			
			sb.append(bfs()).append('\n');
		}
		
		System.out.println(sb);
	}
	
	private static int bfs() {
		int count = 0;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (!visited[i][j] && board[i][j] == 1) {
					
					visited[i][j] = true;
					queue.offer(new int[] {i, j});
					
					while (!queue.isEmpty()) {
						int[] current = queue.poll();
						int currentRow = current[0];
						int currentCol = current[1];
						
						for (int k = 0; k < 4; k++) {
							int nextRow = currentRow + rowDirection[k];
							int nextCol = currentCol + colDirection[k];
							
							if (nextRow >= 0 && nextRow < row &&
								nextCol >= 0 && nextCol < col &&
								!visited[nextRow][nextCol] &&
								board[nextRow][nextCol] == 1) {
								
								visited[nextRow][nextCol] = true;
								queue.offer(new int[] {nextRow, nextCol});
							}
						}
					}
					
					count++;
				}
			}
		}
		
		return count;
	}
}
