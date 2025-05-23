import java.util.*;
import java.io.*;

public class Main {
	
	private static int N;
	private static String[][] r_g_b_board;
	private static int[][] rg_b_board;
	private static boolean[][] visited;
	private static Deque<int[]> queue;
	
	private static int[] rowDirection = {-1, 0, 1, 0};
	private static int[] colDirection = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		r_g_b_board = new String[N][N];
		rg_b_board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < N; j++) {
				String c = String.valueOf(line.charAt(j));
				
				r_g_b_board[i][j] = c;
				
				if (c.equals("B")) {
					rg_b_board[i][j] = 1;
				} else {
					rg_b_board[i][j] = 0;
				}
			}
		}
		
		int r_g_b_count = r_g_b_bfs();
		int rg_b_count = rg_b_bfs();
		
		System.out.println(r_g_b_count + " " + rg_b_count);
	}
	
	private static int r_g_b_bfs() {
		visited = new boolean[N][N];
		queue = new ArrayDeque<>();
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					String current_r_g_b = r_g_b_board[i][j];
					
					visited[i][j] = true;
					queue.offer(new int[] {i, j});
					
					while (!queue.isEmpty()) {
						int[] current = queue.poll();
						int currentRow = current[0];
						int currentCol = current[1];
						
						for (int k = 0; k < 4; k++) {
							int nextRow = currentRow + rowDirection[k];
							int nextCol = currentCol + colDirection[k];
							
							if (nextRow >= 0 && nextRow < N &&
								nextCol >= 0 && nextCol < N &&
								!visited[nextRow][nextCol] &&
								r_g_b_board[nextRow][nextCol].equals(current_r_g_b)) {
								
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
	
	private static int rg_b_bfs() {
		visited = new boolean[N][N];
		queue = new ArrayDeque<>();
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					int current_rg_b = rg_b_board[i][j];
					
					visited[i][j] = true;
					queue.offer(new int[] {i, j});
					
					while (!queue.isEmpty()) {
						int[] current = queue.poll();
						int currentRow = current[0];
						int currentCol = current[1];
						
						for (int k = 0; k < 4; k++) {
							int nextRow = currentRow + rowDirection[k];
							int nextCol = currentCol + colDirection[k];
							
							if (nextRow >= 0 && nextRow < N &&
								nextCol >= 0 && nextCol < N &&
								!visited[nextRow][nextCol] &&
								rg_b_board[nextRow][nextCol] == current_rg_b) {
								
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
