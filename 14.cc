#include <string>
#include <vector>
using namespace std;

class Solution {
public:
  string longestCommonPrefix(vector<string> &strs) {
    if (strs.empty()) return string();
    if (strs.size() == 1) return strs[0];
    string ans = commonPrefix(strs[0], strs[1]);
    for (int i = 2; i < strs.size(); i++)
      ans = commonPrefix(ans, strs[i]);
    return ans;
  }

  string commonPrefix(const string& a, const string& b) {
    int i = 0;
    while (i < a.size() && i < b.size() && a[i] == b[i])
      i++;
    return a.substr(0, i);
  }
};
