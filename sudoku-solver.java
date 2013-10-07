public class Solution {
    public void solveSudoku(char[][] board) {
        // Initialization.
        rowDigit = new boolean[9][9];
        colDigit = new boolean[9][9];
        blkDigit = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int digit = board[i][j] - '1';
                colDigit[j][digit] = rowDigit[i][digit] = true;
                blkDigit[blkId[i][j]][digit] = true;
            }
        }
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int r, int c) {
        if (r == 9) return true;
        int nr = (c == 8 ? r + 1 : r);
        int nc = (c == 8 ? 0 : c + 1);
        if (board[r][c] != '.') return solve(board, nr, nc);
        for (int i = 0; i < 9; i++) {
            if (rowDigit[r][i] || colDigit[c][i] || blkDigit[blkId[r][c]][i])
                continue;
            rowDigit[r][i] = colDigit[c][i] = blkDigit[blkId[r][c]][i] = true;
            board[r][c] = (char) ('1' + i);
            if (solve(board, nr, nc)) return true;
            rowDigit[r][i] = colDigit[c][i] = blkDigit[blkId[r][c]][i] = false;
            board[r][c] = '.';
        }
        return false;
    }

    private boolean[][] rowDigit = null;
    private boolean[][] colDigit = null;
    private boolean[][] blkDigit = null;
    private static int[][] blkId;

    {
        blkId = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                blkId[i][j] = (i / 3) * 3 + j / 3;
            }
        }
    }
}
