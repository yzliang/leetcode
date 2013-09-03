class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int> > &obstacleGrid) {
        if (obstacleGrid.empty() || obstacleGrid[0].empty()) return 0;
        int n = obstacleGrid.size();
        int m = obstacleGrid[0].size();
        vector<vector<int> > num(n, vector<int>(m));
        for (int i = 0; i < n && obstacleGrid[i][0] == 0; i++)
            num[i][0] = 1;
        for (int i = 0; i < m && obstacleGrid[0][i] == 0; i++)
            num[0][i] = 1;
        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                if (obstacleGrid[i][j] == 0)
                    num[i][j] = num[i - 1][j] + num[i][j - 1];
        return num[n - 1][m - 1];
    }
};
