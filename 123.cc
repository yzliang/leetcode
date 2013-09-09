#include <vector>
using namespace std;

class Solution {
public:
  int maxProfit(vector<int> &prices) {
    if (prices.empty()) return 0;
    vector<int> front_profit(prices.size());
    vector<int> back_profit(prices.size());
    int min_price = prices[0];
    for (int i = 1; i < prices.size(); i++) {
      front_profit[i] = max(front_profit[i - 1], prices[i] - min_price);
      min_price = min(prices[i], min_price);
    }
    int max_price = prices.back();
    for (int i = prices.size() - 2; i >= 0; i--) {
      back_profit[i] = max(back_profit[i + 1], max_price - prices[i]);
      max_price = max(prices[i], max_price);
    }
    int ans = back_profit[0];  // One transaction.
    for (int i = 1; i < prices.size(); i++) {
      ans = max(ans, front_profit[i - 1] + back_profit[i]);
    }
    return ans;
  }
};
