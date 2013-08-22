#include <string>
#include <vector>
using namespace std;

class Solution {
public:
  vector<string> letterCombinations(string digits) {
    static const string map[10] = {"", "", "abc", "def", "ghi", "jkl", "mno",
      "pqrs", "tuv", "wxyz"};
    vector<string> ans;
    string letters;
    find_combinations(0, digits, letters, map, ans);
    return ans;
  }

  void find_combinations(int pos, string& digits, string& letters,
      const string map[], vector<string>& combinations) {
    if (pos == digits.size()) {
      combinations.push_back(letters);
      return;
    }
    int digit = digits[pos] - '0';
    for (int i = 0; i < map[digit].size(); i++) {
      letters.push_back(map[digit][i]);
      find_combinations(pos + 1, digits, letters, map, combinations);
      letters.erase(letters.size() - 1);
    }
  }
};
