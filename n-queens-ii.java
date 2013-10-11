public class Solution {
    public int totalNQueens(int n) {
        this.n = n;
        this.total = 0;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        col = new boolean[n];
        diag1 = new boolean[n + n - 1];
        diag2 = new boolean[n + n - 1];
        search(board, 0);
        return total;
    }

    private void search(char[][] board, int r) {
        if (r == n) {
            total++;
            return;
        }
        for (int c = 0; c < n; c++) {
            if (col[c] || diag1[n - 1 - r + c] || diag2[r + c]) continue;
            col[c] = diag1[n - 1 - r + c] = diag2[r + c] = true;
            board[r][c] = 'Q';
            search(board, r + 1);
            board[r][c] = '.';
            col[c] = diag1[n - 1 - r + c] = diag2[r + c] = false;
        }
    }

    private int n;
    private int total;
    private boolean[] col;
    private boolean[] diag1;
    private boolean[] diag2;
}
