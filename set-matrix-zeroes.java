public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean last_row_zero = false;
        boolean last_col_zero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] == 0) last_col_zero = true;
        }
        for (int i = 0; i < n; i++) {
            if (matrix[m - 1][i] == 0) last_row_zero = true;
        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[i][j] == 0) matrix[i][n - 1] = matrix[m - 1][j] = 0;
            }
        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[i][n - 1] == 0 || matrix[m - 1][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        if (last_row_zero) {
            for (int i = 0; i < n; i++) matrix[m - 1][i] = 0;
        }
        if (last_col_zero) {
            for (int i = 0; i < m; i++) matrix[i][n - 1] = 0;
        }
    }
}
