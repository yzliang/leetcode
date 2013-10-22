#include <vector>
using namespace std;

class Solution {
public:
  int maxProfit(vector<int> &prices) {
    if (prices.empty()) return 0;
    int ans = 0;
    int i = 0;
    while (i < prices.size()) {
      int j = i + 1;
      while (j < prices.size() && prices[j] > prices[j - 1]) {
        j++;
      }
      ans += prices[j - 1] - prices[i];
      i = j;
    }
    return ans;
  }
};
