class Solution {
public:
    vector<vector<int> > permute(vector<int> &num) {
        vector<vector<int> > ans;
        search(num, 0, ans);
        return ans;
    }
    
    void search(vector<int>& num, int pos, vector<vector<int> >& ans) {
        if (pos == num.size()) {
            ans.push_back(num);
            return;
        }
        search(num, pos + 1, ans);
        for (int i = pos + 1; i < num.size(); i++) {
            swap(num[pos], num[i]);
            search(num, pos + 1, ans);
            swap(num[pos], num[i]);
        }
    }
    
    void swap(int& a, int& b) {
        int temp = a;
        a = b;
        b = temp;
    }
};
