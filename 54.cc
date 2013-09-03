class Solution {
public:
    vector<int> spiralOrder(vector<vector<int> > &matrix) {
        int n = matrix.size();
        if (n == 0) return vector<int>();
        int m = matrix[0].size();
        if (m == 0) return vector<int>();
        vector<int> output;
        int rows = n, cols = m;
        int level = 0;
        while (rows > 0 && cols > 0) {
            for (int i = 0; i < cols; i++)
                output.push_back(matrix[level][level + i]);
            for (int i = 1; i < rows; i++)
                output.push_back(matrix[level + i][level + cols - 1]);
            if (rows > 1) {
                for (int i = cols - 2; i >= 0; i--)
                    output.push_back(matrix[level + rows - 1][level + i]);
            }
            if (cols > 1) {
                for (int i = rows - 2; i > 0; i--)
                    output.push_back(matrix[level + i][level]);
            }
            level++;
            rows -= 2;
            cols -= 2;
        }
        return output;
    }
};
