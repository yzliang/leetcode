#include <string>
using namespace std;

class Solution {
public:
  string intToRoman(int num) {
    static const char one[] = {'I', 'X', 'C', 'M'};
    static const char five[] = {'V', 'L', 'D'};
    int digit[4];
    for (int i = 0; i < 4; i++) {
      digit[i] = num % 10;
      num /= 10;
    }
    string ans;
    for (int i = 3; i >= 0; i--) {
      if (digit[i] == 0) continue;
      if (digit[i] <= 3) {
        for (int j = 0; j < digit[i]; j++) ans += one[i];
      } else if (digit[i] == 4) {
        ans += one[i];
        ans += five[i];
      } else if (digit[i] <= 8) {
        ans += five[i];
        for (int j = 5; j < digit[i]; j++) ans += one[i];
      } else if (digit[i] == 9) {
        ans += one[i];
        ans += one[i + 1];
      }
    }
    return ans;
  }
};
