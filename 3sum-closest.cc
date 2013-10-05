#include <algorithm>
#include <climits>
#include <cmath>
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
  int threeSumClosest(vector<int> &num, int target) {
    int best = num[0] + num[1] + num[2];
    sort(num.begin(), num.end());
    for (int i = 0; i < num.size(); i++) {
      for (int j = i + 1; j < num.size(); j++) {
        int k = target - num[i] - num[j];
        int l = 0, r = num.size() - 1;
        while (l <= r) {
          int mid = (l + r) / 2;
          if (num[mid] < k)
            l = mid + 1;
          else
            r = mid - 1;
        }
        if (l <= j) l = j + 1;
        if (l > j && l < num.size()) {
          if (abs(num[i] + num[j] + num[l] - target) < abs(best - target)) {
            best = num[i] + num[j] + num[l];
          }
          if (best == target) return best;
        }
        if (l - 1 > j && abs(num[i] + num[j] + num[l - 1] - target) <
            abs(best - target))
          best = num[i] + num[j] + num[l - 1];
      }
    }
    return best;
  }
};

int main() {
  int a[] = {0, 5, -1, -2, 4, -1, 0, -3, 4, -5};
  vector<int> num(a, a + 10);
  Solution s;
  cout << s.threeSumClosest(num, 1) << endl;
  return 0;
}
