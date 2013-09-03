class Solution {
public:
    int totalNQueens(int n) {
        this->n = n;
        vector<bool> col(n);
        vector<bool> diag1(n + n -1);
        vector<bool> diag2(n + n - 1);
        vector<int> states;
        total = 0;
        search(0, states, col, diag1, diag2);
        return total;
    }
    
    void search(int row, vector<int>& states, vector<bool>& col,
            vector<bool>& diag1, vector<bool>& diag2) {
        if (row == n) {
            total++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] || diag1[(n - 1) - row + i] || diag2[i + row])
                continue;
            states.push_back(i);
            col[i] = diag1[(n - 1) - row + i] = diag2[i + row] = true;
            search(row + 1, states, col, diag1, diag2);
            states.pop_back();
            col[i] = diag1[(n - 1) - row + i] = diag2[i + row] = false;            
        }
    }
private:
    int n;
    int total;
};
