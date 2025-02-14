class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1RowLength = arr1.length;
        int arr1ColumnLength = arr1[0].length;
        int arr2RowLength = arr2.length;
        int arr2ColumnLength = arr2[0].length;
        
        int[][] answer = new int[arr1RowLength][arr2ColumnLength];
        for (int i = 0; i < arr1RowLength; i++) {
            for (int j = 0; j < arr2ColumnLength; j++) {
                for (int k = 0; k < arr1ColumnLength; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}