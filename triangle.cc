#include <vector>
using namespace std;

class Solution {
public:
  int minimumTotal(vector<vector<int> >& triangle) {
    vector<int> min_sum(triangle.size());
    for (int i = 0; i < triangle.size(); i++) {
      int prev = min_sum[0];
      min_sum[0] += triangle[i][0];
      for (int j = 1; j < i; j++) {
        int temp = min_sum[j];
        min_sum[j] = min(prev, min_sum[j]) + triangle[i][j];
        prev = temp;
      }
      min_sum[i] = prev + triangle[i][i];
    }
    int ans = INT_MAX;
    for (int i = 0; i < triangle.size(); i++) {
      if (min_sum[i] < ans) ans = min_sum[i];
    }
    return ans;
  }
};
