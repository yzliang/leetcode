#include <vector>
using namespace std;

class Solution {
public:
  vector<int> grayCode(int n) {
    vector<int> ans;
    ans.push_back(0);
    int total = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < total; j++) {
        ans.push_back(ans[j] | (1 << i));
      }
      reverse(ans.begin() + total, ans.end());
      total *= 2;
    }
    return ans;
  }
};
