import java.util.*;
import java.io.*;

class Main {

    static int n, m;
    static int pictureCount;
    static int pictureSize;
    static boolean[][] visited;
    static int[][] board;
    static Deque<int[]> queue = new ArrayDeque<>();

    static int[] rowDirection = {-1, 0, 1, 0};
    static int[] colDirection = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        board = new int[n][m];
        pictureCount = 0;
        pictureSize = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.offer(new int[] {i, j});
                    pictureCount++;
                    bfs();
                }
            }
        }

        System.out.println(pictureCount);
        System.out.println(pictureSize);
    }

    static void bfs() {
        int size = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            size++;

            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + rowDirection[i];
                int nextCol = currentCol + colDirection[i];

                if (nextRow >= 0 && nextRow < n &&
                        nextCol >= 0 && nextCol < m &&
                        board[nextRow][nextCol] == 1 &&
                        !visited[nextRow][nextCol]) {

                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }

        pictureSize = Math.max(pictureSize, size);
    }
}