#include <utility>
#include <vector>
using namespace std;

class Solution {
public:
  vector<vector<int> > combinationSum2(vector<int> &candidates, int target) {
    sort(candidates.begin(), candidates.end());
    vector<pair<int, int> > pairs;
    int num = 1;
    for (int i = 1; i < candidates.size(); i++) {
      if (candidates[i] != candidates[i - 1]) {
        pairs.push_back(make_pair(candidates[i - 1], num));
        num = 0;
      }
      num++;
    }
    if (!candidates.empty() && num > 0)
      pairs.push_back(make_pair(candidates.back(), num));
    vector<vector<int> > ans;
    vector<int> combo;
    search(pairs, 0, combo, 0, target, ans);
    return ans;
  }
  
  void search(vector<pair<int, int> >& candidates, int pos,
      vector<int>& combo, int sum, int target, vector<vector<int> >& ans) {
    if (sum == target) {
      ans.push_back(combo);
      return;
    }
    if (pos == candidates.size()) return;
    for (int i = 1; i <= candidates[pos].second; i++) {
      if (sum + i * candidates[pos].first > target) break;
      combo.push_back(candidates[pos].first);
      search(candidates, pos + 1, combo, sum + i * candidates[pos].first,
          target, ans);
    }
    // Backtracking.
    while (!combo.empty() && combo.back() == candidates[pos].first)
      combo.pop_back();
    search(candidates, pos + 1, combo, sum, target, ans);
  }
};
