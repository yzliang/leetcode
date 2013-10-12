public class Solution {
    public int uniquePathsWithObstacles(int[][] f) {
        int rows = f.length;
        int cols = f[0].length;
        f[0][0] = 1 - f[0][0];
        for (int i = 1; i < cols; i++)
            f[0][i] = f[0][i - 1] == 0 ? 0 : 1 - f[0][i];
        for (int i = 1; i < rows; i++)
            f[i][0] = f[i - 1][0] == 0 ? 0 : 1 - f[i][0];
        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++)
                f[i][j] = f[i][j] == 1 ? 0 : f[i - 1][j] + f[i][j - 1];
        return f[rows - 1][cols - 1];
    }
}
