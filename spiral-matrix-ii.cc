class Solution {
public:
    vector<vector<int> > generateMatrix(int n) {
        vector<vector<int> > ans(n, vector<int>(n));
        static const int dx[4] = {0, 1, 0, -1};
        static const int dy[4] = {1, 0, -1, 0};
        int x = 0, y = 0;
        int dir = 0;
        for (int i = 1; i <= n * n; i++) {
            ans[x][y] = i;
            int nx = x + dx[dir], ny = y + dy[dir];
            if (nx < 0 || nx == n || ny < 0 || ny == n || ans[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                x += dx[dir];
                y += dy[dir];
            } else {
                x = nx;
                y = ny;
            }
        }
        return ans;
    }
};
