#include <string>
#include <vector>
using namespace std;

class Solution {
public:
  int minCut(string s) {
    vector<vector<bool> > is_pal(s.size(), vector<bool>(s.size()));
    for (int i = 0; i < s.size(); i++) {
      int l = i, r = i;
      while (l >= 0 && r < s.size() && s[l] == s[r])
        is_pal[l--][r++] = true;
      l = i - 1;
      r = i;
      while (l >= 0 && r < s.size() && s[l] == s[r])
        is_pal[l--][r++] = true;
    }
    vector<int> min_cut(s.size(), -1);
    for (int i = 0; i < s.size(); i++) {
      if (is_pal[0][i]) {
        min_cut[i] = 0;
        continue;
      }
      for (int j = 0; j < i; j++) {
        if (is_pal[j + 1][i] && (min_cut[i] == -1 ||
              min_cut[j] + 1 < min_cut[i])) {
          min_cut[i] = min_cut[j] + 1;
        }
      }
    }
    return min_cut[s.size() - 1];
  }
};
