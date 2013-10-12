public class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0) return null;
        int[][] ans = new int[n][n];
        int number = 1;
        for (int i = 0; i < n / 2; i++) {
            int size = n - i - i;
            for (int j = 0; j < size; j++)
                ans[i][i + j] = number++;
            for (int j = 1; j < size; j++)
                ans[i + j][i + size - 1] = number++;
            for (int j = size - 2; j >= 0; j--)
                ans[i + size - 1][i + j] = number++;
            for (int j = size - 2; j > 0; j--)
                ans[i + j][i] = number++;
        }
        if (n % 2 != 0)
            ans[n / 2][n / 2] = n * n;
        return ans;
    }
}
