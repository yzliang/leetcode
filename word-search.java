public class Solution {
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        used = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != word.charAt(0)) continue;
                used[i][j] = true;
                if (search(board, i, j, 1, word)) return true;
                used[i][j] = false;
            }
        }
        return false;
    }

    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    private boolean search(char[][] board, int x, int y, int pos, String word) {
        if (pos == word.length()) return true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx == rows || ny < 0 || ny == cols) continue;
            if (used[nx][ny] || board[nx][ny] != word.charAt(pos)) continue;
            used[nx][ny] = true;
            if (search(board, nx, ny, pos + 1, word)) return true;
            used[nx][ny] = false;
        }
        return false;
    }

    private int rows, cols;
    private boolean[][] used;
}
