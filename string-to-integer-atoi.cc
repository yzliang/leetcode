#include <cctype>
#include <climits>
#include <cstdlib>

class Solution {
public:
  int atoi(const char *str) {
    if (str == NULL) return 0;
    // Skip leading spaces.
    while (*str && isspace(*str))
      str++;
    if (*str == '\0') return 0;
    // Sign.
    bool negative = false;
    if (*str == '-' || *str == '+') {
      negative = *str == '-';
      str++;
    }
    // Value.
    int val = 0;
    while (*str && isdigit(*str)) {
      int digit = *str++ - '0';
      if (!negative) {
        if (val > (INT_MAX - digit) / 10)
          return INT_MAX;
        val = val * 10 + digit;
      } else {
        if (val < (INT_MIN + digit) / 10)
          return INT_MIN;
        val = val * 10 - digit;
      }
    }
    return val;
  }
};
