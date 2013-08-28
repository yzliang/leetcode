public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!(board[i][j] == '.' || (board[i][j] >= '1' && board[i][j] <= '9'))) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            boolean[] num = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (num[board[i][j] - '1']) return false;
                num[board[i][j] - '1'] = true;
            }
        }
        for (int i = 0; i < 9; i++) {
            boolean[] num = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                if (num[board[j][i] - '1']) return false;
                num[board[j][i] - '1'] = true;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int ox = i * 3, oy = j * 3;
                boolean[] num = new boolean[9];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (board[ox + x][oy + y] == '.') continue;
                        if (num[board[ox + x][oy + y] - '1']) return false;
                        num[board[ox + x][oy + y] - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
}
