import java.util.*;

class Solution {
    private int[][] board;
    private int n, m;
    private int[][] visitedCount;
    private int[] rowDirection = {-1, 1, 0, 0};
    private int[] colDirection = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        board = maps;
        n = maps.length;
        m = maps[0].length;
        visitedCount = new int[n][m];
        
        bfs(0, 0);
        
        int result = visitedCount[n - 1][m - 1];
        return (result == 0) ? -1 : result;
    }
    
    private void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{row, col});
        visitedCount[row][col] = 1;
        
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
                    visitedCount[nextRow][nextCol] == 0) {
                    
                    visitedCount[nextRow][nextCol] = visitedCount[currentRow][currentCol] + 1;
                    
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
    }
}