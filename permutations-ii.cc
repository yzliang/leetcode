class Solution {
public:
    vector<vector<int> > permuteUnique(vector<int> &num) {
        vector<vector<int> > ans;
        search(num, 0, ans);
        sort(ans.begin(), ans.end());
        ans.resize(unique(ans.begin(), ans.end()) - ans.begin());
        return ans;
    }
    
    void search(vector<int>& num, int pos, vector<vector<int> >& ans) {
        if (pos == num.size()) {
            ans.push_back(num);
            return;
        }
        search(num, pos + 1, ans);
        for (int i = 0; i < pos; i++) {
            if (num[i] == num[pos]) continue;
            swap(num[i], num[pos]);
            search(num, pos + 1, ans);
            swap(num[i], num[pos]);
        }
    }
    
    void swap(int& a, int& b) {
        int temp = a;
        a = b;
        b = temp;
    }
};
