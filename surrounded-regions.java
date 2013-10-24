public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O')
                floodFill(board, 0, i, 'O', '#');
            if (board[rows - 1][i] == 'O')
                floodFill(board, rows - 1, i, 'O', '#');
        }
        for (int i = 1; i < rows - 1; i++) {
            if (board[i][0] == 'O')
                floodFill(board, i, 0, 'O', '#');
            if (board[i][cols - 1] == 'O')
                floodFill(board, i, cols - 1, 'O', '#');
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private static class Position {
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[] dx = new int[]{0, 1, 0, -1};
    private static int[] dy = new int[]{1, 0, -1, 0};

    private void floodFill(char[][] board, int sx, int sy, char origin,
            char replace) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visit = new boolean[rows][cols];
        Queue<Position> queue = new ArrayDeque<Position>();
        visit[sx][sy] = true;
        queue.add(new Position(sx, sy));
        while (!queue.isEmpty()) {
            Position head = queue.poll();
            board[head.x][head.y] = replace;
            for (int i = 0; i < 4; i++) {
                int nx = head.x + dx[i];
                int ny = head.y + dy[i];
                if (nx < 0 || nx == rows || ny < 0 || ny == cols) continue;
                if (visit[nx][ny] || board[nx][ny] != origin) continue;
                visit[nx][ny] = true;
                queue.add(new Position(nx, ny));
            }
        }
    }
}

