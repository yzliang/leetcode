class Solution {
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        int n = matrix.size();
        int m = matrix[0].size();
        // Search for row.
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[mid][m - 1] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (l == n) return false;
        // Search for column.
        int row = l;
        l = 0;
        r = m - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[row][mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l < m && matrix[row][l] == target;
    }
};
