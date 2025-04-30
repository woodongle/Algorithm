import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append("\n");

			int N = Integer.parseInt(br.readLine());
			String[][] board = new String[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					board[i][j] = st.nextToken();
				}
			}

			// 90도, 180도, 270도 회전
			String[][] rotated90 = rotate90(board);
			String[][] rotated180 = rotate90(rotated90);
			String[][] rotated270 = rotate90(rotated180);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(rotated90[i][j]);
				}
				
				sb.append(" ");
				
				for (int j = 0; j < N; j++) {
					sb.append(rotated180[i][j]);
				}
				
				sb.append(" ");
				
				for (int j = 0; j < N; j++) {
					sb.append(rotated270[i][j]);
				}
				
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}

	private static String[][] rotate90(String[][] board) {
		int N = board.length;
		String[][] result = new String[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result[j][N - 1 - i] = board[i][j];
			}
		}

		return result;
	}
}
