#include <vector>
using namespace std;

class Solution {
public:
  vector<vector<int> > subsets(vector<int> &S) {
    vector<vector<int> > ans;
    int total = pow(2, S.size());
    sort(S.begin(), S.end());
    for (int i = 0; i < total; i++) {
      int code = i;
      vector<int> subset;
      for (int j = 0; j < S.size(); j++) {
        if (code & 1) subset.push_back(S[j]);
        code >>= 1;
      }
      ans.push_back(subset);
    }
    return ans;
  }
};
