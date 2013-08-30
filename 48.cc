class Solution {
public:
    void rotate(vector<vector<int> > &matrix) {
        if (matrix.empty()) return;
        int n = matrix.size();
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                move(matrix, i, j);
            }
        }
        if (n % 2) {
            for (int i = 0; i < n / 2; i++) move(matrix, i, n / 2);
        }
    }
    
    void move(vector<vector<int> >& matrix, int i, int j) {
        int n = matrix.size();
        int temp = matrix[i][j];
        int x = i, y = j;
        for (int k = 0; k < 3; k++) {
            matrix[x][y] = matrix[n - y - 1][x];
            int temp = x;
            x = n - y - 1;
            y = temp;
        }
        matrix[j][n - i - 1] = temp;
    }
};
