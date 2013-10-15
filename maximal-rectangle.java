public class Solution {

    private static class Bar {
        int index;
        int height;

        public Bar(int i, int h) {
            this.index = i;
            this.height = h;
        }
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        // Compute heights.
        int[][] height = new int[rows][cols];
        for (int i = 0; i < cols; i++)
            height[0][i] = matrix[0][i] - '0';
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                height[i][j] = matrix[i][j] == '0' ? 0 : height[i - 1][j] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            Stack<Bar> stack = new Stack<Bar>();
            for (int j = 0; j < cols; j++) {
                while (!stack.empty() && stack.peek().height > height[i][j]) {
                    Bar top = stack.pop();
                    int left = stack.empty() ? 0 : stack.peek().index + 1;
                    ans = Math.max(ans, (j - left) * top.height);
                }
                stack.push(new Bar(j, height[i][j]));
            }
            while (!stack.empty()) {
                Bar top = stack.pop();
                int left = stack.empty() ? 0 : stack.peek().index + 1;
                ans = Math.max(ans, (cols - left) * top.height);
            }
        }
        return ans;
    }
}
