#include <vector>
using namespace std;

class Solution {
public:
  vector<int> getRow(int rowIndex) {
    vector<int> ans;
    for (int i = 0; i <= rowIndex; i++) {
      int prev = 1;
      for (int j = 1; j < i; j++) {
        int temp = ans[j];
        ans[j] += prev;
        prev = temp;
      }
      ans.push_back(1);
    }
    return ans;
  }
};
