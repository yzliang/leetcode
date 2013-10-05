#include <cstdlib>

class Solution {
public:
  bool isMatch(const char *s, const char *p) {
    if (s == NULL || p == NULL) return false;
    if (s[0] == '\0' && p[0] == '\0') return true;
    if (s[0] != '\0' && p[0] == '\0') return false;
    if (p[1] != '*') {
      if (s[0] != '\0' && (s[0] == p[0] || p[0] == '.'))
        return isMatch(s + 1, p + 1);
    } else {
      if (isMatch(s, p + 2))
        return true;
      for (int i = 0; s[i] != '\0' && (s[i] == p[0] || p[0] == '.'); i++) {
        if (isMatch(&s[i + 1], p + 2))
          return true;
      }
    }
    return false;
  }
};
