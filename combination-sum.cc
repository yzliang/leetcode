class Solution {
public:
    vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
        sort(candidates.begin(), candidates.end());
        candidates.resize(unique(candidates.begin(), candidates.end()) -
                candidates.begin());
        vector<vector<int> > ans;
        vector<int> combo;
        search(candidates, 0, combo, 0, target, ans);
        return ans;
    }
    
    void search(vector<int>& candidates, int pos, vector<int>& combo, int sum,
            int target, vector<vector<int> >& ans) {
        if (sum + candidates[pos] == target) {
            combo.push_back(candidates[pos]);
            ans.push_back(combo);
            combo.pop_back();
            return;
        }
        if (sum + candidates[pos] < target) {
            combo.push_back(candidates[pos]);
            search(candidates, pos, combo, sum + candidates[pos], target, ans);
            combo.pop_back();
        }
        if (sum + candidates[pos] > target) return;
        if (pos + 1 < candidates.size())
            search(candidates, pos + 1, combo, sum, target, ans);
    }
};
