#include <string>
using namespace std;

class Solution {
public:
  // nRows == 1 !!
  string convert(string s, int n) {
    if (n == 1) return s;
    string ans;
    ans.reserve(s.size());
    for (int i = 0; i < s.size(); i += n + n - 2)
      ans.push_back(s[i]);
    for (int i = 1; i < n - 1; i++) {
      for (int j = i; j < s.size(); j += n + n - 2) {
        ans.push_back(s[j]);
        if (j + (n - i - 1) * 2 < s.size())
          ans.push_back(s[j + (n - i - 1) * 2]);
      }
    }
    for (int i = n - 1; i < s.size(); i += n + n - 2)
      ans.push_back(s[i]);
    return ans;
  }
};
