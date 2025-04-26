import java.io.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            sb.append("#").append(i).append("\n");

            int N = Integer.parseInt(br.readLine());
            int[][] snail = new int[N][N];
            int rowStart = 0;
            int rowEnd = N - 1;
            int colStart = 0;
            int colEnd = N - 1;
            int num = 1;

            makeSnail(rowStart, rowEnd, colStart, colEnd, snail, num);

            for (int[] parts : snail) {
                for (int j = 0; j < snail[0].length; j++) {
                    sb.append(parts[j]).append(" ");
                }

                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void makeSnail(int rowStart, int rowEnd, int colStart, int colEnd, int[][] snail, int num) {
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 오른쪽으로 이동
            for (int j = colStart; j <= colEnd; j++) {
                snail[rowStart][j] = num++;
            }
            rowStart++;

            // 아래쪽으로 이동
            for (int j = rowStart; j <= rowEnd; j++) {
                snail[j][colEnd] = num++;
            }
            colEnd--;

            // 왼쪽으로 이동
            if (rowStart <= rowEnd) {
                for (int j = colEnd; j >= colStart; j--) {
                    snail[rowEnd][j] = num++;
                }
                rowEnd--;
            }

            // 위쪽으로 이동
            if (colStart <= colEnd) {
                for (int j = rowEnd; j >= rowStart; j--) {
                    snail[j][colStart] = num++;
                }
                colStart++;
            }
        }
    }
}
