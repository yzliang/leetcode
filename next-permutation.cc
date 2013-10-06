#include <algorithm>
#include <vector>
using namespace std;

class Solution {
public:
  void nextPermutation(vector<int> &num) {
    for (int i = num.size() - 2; i >= 0; i--) {
      if (num[i] < num[i + 1]) {
        reverse(num.begin() + i + 1, num.end());
        int l = i + 1, r = num.size() - 1;
        while (l <= r) {
          int mid = (l + r) / 2;
          if (num[mid] <= num[i]) {
            l = mid + 1;
          } else {
            r = mid - 1;
          }
        }
        int temp = num[l];
        num[l] = num[i];
        num[i] = temp;
        return;
      }
    }
    reverse(num.begin(), num.end());
  }
};
