#include <climits>

class Solution {
public:
  // Be careful about tricky boundries!!
  int divide(int dividend, int divisor) {
    if (dividend == 0 || divisor == 0) return 0;
    bool negative = (dividend > 0) ^ (divisor > 0);
    int ret = 0;
    // Do things in positive.
    if (divisor < 0) {
      if (divisor == INT_MIN)
        return dividend == INT_MIN ? 1 : 0;
      divisor = -divisor;
    }
    if (dividend < 0) {
      if (dividend == INT_MIN) {
        dividend += divisor;
        ret++;
      }
      dividend = -dividend;
    }
    // Division.
    while (dividend >= divisor) {
      int times = 1, val = divisor, last_times, last_val;
      while (val > 0 && val <= dividend) {
        last_val = val;
        val += val;
        last_times = times;
        times += times;
      }
      ret += last_times;
      dividend -= last_val;
    }
    if (negative) ret = -ret;
    return ret;
  }
};
