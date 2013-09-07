#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
  bool isScramble(string s1, string s2) {
    int n = s1.size();
    vector<vector<vector<bool> > > match(n + 1, vector<vector<bool> >(n,
          vector<bool>(n)));
    // Initialize.
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (s1[i] == s2[j])
          match[1][i][j] = true;
      }
    }
    for (int len = 2; len <= n; len++) {  // Length, the stage of DP.
      for (int i = 0; i <= n - len; i++) {
        for (int j = 0; j <= n - len; j++) {
          // No scrambling.
          if (s1.compare(i, len, s2, j, len) == 0) {
            match[len][i][j] = true;
            continue;
          }
          for (int l1 = 1; l1 < len; l1++) {
            int l2 = len - l1;
            if (match[l1][i][j] && match[l2][i + l1][j + l1]) {
              match[len][i][j] = true;
              break;
            }
            if (match[l1][i][j + l2] && match[l2][i + l1][j]) {
              match[len][i][j] = true;
              break;
            }
          }
        }
      }
    }
    return match[n][0][0];
  }
};
