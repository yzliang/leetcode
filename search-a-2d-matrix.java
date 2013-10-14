public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        // Locate the row.
        int l = 0, r = matrix.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[mid][n - 1] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int row = l;
        if (row == m) return false;
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[row][mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l < n && matrix[row][l] == target;
    }
}
