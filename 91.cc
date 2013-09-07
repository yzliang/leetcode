#include <string>
#include <vector>
using namespace std;

class Solution {
public:
  int numDecodings(string s) {
    if (s.empty()) return 0;
    vector<int> ways(s.size() + 1);
    ways[0] = 1;
    for (int i = 0; i < s.size(); i++) {
      if (s[i] != '0') {
        ways[i + 1] += ways[i];
      }
      if (i < s.size() - 1) {
        int val = (s[i] - '0') * 10 + s[i + 1] - '0';
        if (val >= 10 && val <= 26) {
          ways[i + 2] += ways[i];
        }
      }
    }
    return ways[s.size()];
  }
};
