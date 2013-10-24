#include <unordered_set>
#include <vector>
using namespace std;

class Solution {
public:
  int longestConsecutive(vector<int>& num) {
    unordered_set<int> num_set;
    for (int i = 0; i < num.size(); i++)
      num_set.insert(num[i]);
    int ret = 0;
    for (int i = 0; i < num.size(); i++) {
      unordered_set<int>::iterator it = num_set.find(num[i]);
      if (it == num_set.end()) continue;
      num_set.erase(it);
      int len = 1;
      for (int j = num[i] + 1; (it = num_set.find(j)) != num_set.end(); j++) {
        num_set.erase(it);
        len++;
      }
      for (int j = num[i] - 1; (it = num_set.find(j)) != num_set.end(); j--) {
        num_set.erase(it);
        len++;
      }
      if (len > ret) ret = len;
    }
    return ret;
  }
};
