import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			sb.append("#").append(i + 1).append(" ");
			
			int[][] sudoku = new int[9][9];
			
			for (int j = 0; j < 9; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int k = 0; k < 9; k++) {
					sudoku[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			if (validateSudoku(sudoku)) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static boolean validateSudoku(int[][] sudoku) {
		// 1. 행 검증
		HashSet<Integer> set = new HashSet<>();
		
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                set.add(sudoku[i][j]);
            }
            
            if (set.size() != 9) {
                return false;
            }
            
            set.clear();
        }
        
        set.clear();
        
        // 2. 열 검증
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                set.add(sudoku[i][j]);
            }
            
            if (set.size() != 9) {
                return false;
            }
            
            set.clear();
        }
        
        set.clear();
        
        // 3 X 3 검증
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                for (int i = boxRow * 3; i < boxRow * 3 + 3; i++) {
                    for (int j = boxCol * 3; j < boxCol * 3 + 3; j++) {
                        set.add(sudoku[i][j]);
                    }
                }
                if (set.size() != 9) {
                    return false;
                }
            }
        }
        
        return true;
	}
}
