class Solution {
public:
    void setZeroes(vector<vector<int> > &matrix) {
        if (matrix.empty() || matrix[0].empty()) return;
        bool last_column = false;
        bool last_row = false;
        int n = matrix.size();
        int m = matrix[0].size();
        for (int i = 0; i < n; i++) {
            if (matrix[i][m - 1] == 0) {
                last_column = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[n - 1][i] == 0) {
                last_row = true;
                break;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][m - 1] = matrix[n - 1][j] = 0;
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (matrix[i][m - 1] == 0) {
                for (int j = 0; j < m - 1; j++) matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < m - 1; i++) {
            if (matrix[n - 1][i] == 0) {
                for (int j = 0; j < n - 1; j++) matrix[j][i] = 0;
            }
        }
        if (last_row) {
            for (int i = 0; i < m; i++) matrix[n - 1][i] = 0;
        }
        if (last_column) {
            for (int i = 0; i < n; i++) matrix[i][m - 1] = 0;
        }
    }
};
