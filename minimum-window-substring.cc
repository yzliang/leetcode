#include <climits>
#include <string>
using namespace std;

class Solution {
public:
  string minWindow(string S, string T) {
    int in_t[CHAR_MAX - CHAR_MIN + 1] = {false};
    for (int i = 0; i < T.size(); i++) {
      in_t[T[i] - CHAR_MIN]++;
    }
    int in_s[CHAR_MAX - CHAR_MIN + 1] = {0};
    int l = 0, r = 0;
    int cover = 0;
    while (r < S.size() && cover < T.size()) {
      if (in_s[S[r] - CHAR_MIN] < in_t[S[r] - CHAR_MIN]) {
        cover++;
      }
      in_s[S[r] - CHAR_MIN]++;
      r++;
    }
    if (cover < T.size()) return "";
    int best_l = l, best_r = r;
    while (l < r) {
      // Left++.
      if (in_s[S[l] - CHAR_MIN] <= in_t[S[l] - CHAR_MIN]) {
        cover--;
      }
      in_s[S[l] - CHAR_MIN]--;
      l++;
      // Right++.
      while (cover < T.size() && r < S.size()) {
        if (in_s[S[r] - CHAR_MIN] < in_t[S[r] - CHAR_MIN]) {
          cover++;
        }
        in_s[S[r] - CHAR_MIN]++;
        r++;
      }
      if (cover < T.size()) break;
      if (r - l < best_r - best_l) {
          best_l = l;
          best_r = r;
      }
    }
    return S.substr(best_l, best_r - best_l);
  }
};
