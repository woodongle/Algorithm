import java.io.*;
import java.util.*;

public class Main {
	
	private static int N;
	private static Deque<int[]> queue;
	private static boolean[][] visited;
	private static int[][] board;
	
	private static int[] rowDirection = {-1, 0, 1, 0};
	private static int[] colDirection = {0, 1, 0, -1};
	
	private static List<Integer> counts;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		
		N = Integer.parseInt(br.readLine());
		
		queue = new ArrayDeque<>();
		visited = new boolean[N][N];
		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < N; j++) {
				int value = line.charAt(j) - '0';
				
				board[i][j] = value;
			}
		}
		
		bfs();
		
		sb = new StringBuilder();
		sb.append(counts.size()).append('\n');
		
		for (int count : counts) {
			sb.append(count).append('\n');
		}
		
		System.out.println(sb);
	}
	
	private static void bfs() {
		counts = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && board[i][j] == 1) {
					int count = 0;
					
					visited[i][j] = true;
					queue.offer(new int[] {i, j});
					count++;
					
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
								board[nextRow][nextCol] == 1) {
								
								
								visited[nextRow][nextCol] = true;
								queue.offer(new int[] {nextRow, nextCol});
								count++;
							}
						}
					}
					
					counts.add(count);
				}
			}
		}
		
		Collections.sort(counts);
	}
}
