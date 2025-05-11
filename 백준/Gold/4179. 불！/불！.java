import java.io.*;
import java.util.*;

class Main {

	private static int R, C;
	private static char[][] board;
	private static int[][] JMaze;
	private static int[][] FMaze;
	private static Queue<int[]> JQueue = new LinkedList<>();
	private static Queue<int[]> FQueue = new LinkedList<>();

	private static int[] rowDirection = { -1, 0, 1, 0 };
	private static int[] colDirection = { 0, -1, 0, 1 };

	private static final int wall = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		JMaze = new int[R][C];
		FMaze = new int[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();

			for (int j = 0; j < C; j++) {
				board[i][j] = line.charAt(j);
				JMaze[i][j] = wall;
				FMaze[i][j] = wall;

				if (board[i][j] == 'J') {
					JQueue.offer(new int[] { i, j });
					JMaze[i][j] = 0;
				} else if (board[i][j] == 'F') {
					FQueue.offer(new int[] { i, j });
					FMaze[i][j] = 0;
				}
			}
		}
		
		bfsJ();
		bfsF();
		
		int minTime = wall;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if ((i == 0 || i == R - 1 || j == 0 || j == C - 1) && board[i][j] != '#') {
					if (JMaze[i][j] != wall && (FMaze[i][j] == wall || JMaze[i][j] < FMaze[i][j])) {
						minTime = Math.min(minTime, JMaze[i][j]);
					}
				}
			}
		}
		
		if (minTime == wall) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(minTime + 1);
		}
	}

	private static void bfsJ() {
		while (!JQueue.isEmpty()) {
			int[] current = JQueue.poll();
			int currentRow = current[0];
			int currentCol = current[1];
			
			for (int i = 0; i < 4; i++) {
				int nextRow = currentRow + rowDirection[i];
				int nextCol = currentCol + colDirection[i];
				
				if (nextRow >= 0 && nextRow < R && 
					nextCol >= 0 && nextCol < C && 
					board[nextRow][nextCol] != '#') {
					
					if (JMaze[nextRow][nextCol] == wall && 
						(FMaze[nextRow][nextCol] == wall || JMaze[currentRow][currentCol] + 1 < FMaze[nextRow][nextCol])) {
						
						JMaze[nextRow][nextCol] = JMaze[currentRow][currentCol] + 1;
						JQueue.offer(new int[] {nextRow, nextCol});
					}
				}
			}
		}
	}
	
	private static void bfsF() {
		while (!FQueue.isEmpty()) {
			int[] current = FQueue.poll();
			int currentRow = current[0];
			int currentCol = current[1];
			
			for (int i = 0; i < 4; i++) {
				int nextRow = currentRow + rowDirection[i];
				int nextCol = currentCol + colDirection[i];
				
				if (nextRow >= 0 && nextRow < R && 
					nextCol >= 0 && nextCol < C && 
					board[nextRow][nextCol] != '#') {
					
					if (FMaze[nextRow][nextCol] == wall) {
						FMaze[nextRow][nextCol] = FMaze[currentRow][currentCol] + 1;
						FQueue.offer(new int[] {nextRow, nextCol});
					}
				}
			}
		}
	}
}
