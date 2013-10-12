public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (matrix == null) return ans;
        if (matrix.length == 0 || matrix[0].length == 0) return ans;
        int sx = 0, sy = 0;
        int rows = matrix.length, cols = matrix[0].length;
        while (rows > 0 && cols > 0) {
            for (int i = 0; i < cols; i++)
                ans.add(matrix[sx][sy + i]);
            for (int i = 1; i < rows; i++)
                ans.add(matrix[sx + i][sy + cols - 1]);
            if (rows > 1) {
                for (int i = cols - 2; i >= 0; i--)
                    ans.add(matrix[sx + rows - 1][sy + i]);
            }
            if (cols > 1) {
                for (int i = rows - 2; i > 0; i--)
                    ans.add(matrix[sx + i][sy]);
            }
            sx++;
            sy++;
            rows -= 2;
            cols -= 2;
        }
        return ans;
    }
}
