#include <string>
#include <vector>
using namespace std;

class Solution {
public:
  vector<string> restoreIpAddresses(string s) {
    vector<string> ans;
    vector<string> current;
    search(current, s, 0, 1, ans);
    return ans;
  }

  void search(vector<string>& current, string& s, int pos, int field,
      vector<string>& ans) {
    if (field == 4) {
      if (check(s, pos, s.size() - pos)) {
        string ip;
        for (int i = 0; i < current.size(); i++) {
          ip += current[i];
          ip += '.';
        }
        ip += s.substr(pos);
        ans.push_back(ip);
      }
      return;
    }
    for (int i = 1; i <= 3; i++) {
      if (pos + i < s.size() && check(s, pos, i)) {
        current.push_back(s.substr(pos, i));
        search(current, s, pos + i, field + 1, ans);
        current.pop_back();
      }
    }
  }

  bool check(string& s, int pos, int len) {
    int val;
    switch (len) {
      case 1:
        return true;
      case 2:
        val = (s[pos] - '0') * 10 + (s[pos + 1] - '0');
        return val >= 10;
      case 3:
        val = (s[pos] - '0') * 100 + (s[pos + 1] - '0') * 10 +
          (s[pos + 2] - '0');
        return val >= 100 && val <= 255;
      default:
        return false;
    }
  }
};
