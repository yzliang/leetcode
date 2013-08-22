#include <string>
#include <stack>
using namespace std;

class Solution {
public:
  bool isValid(string s) {
    stack<char> parens;
    for (int i = 0; i < s.size(); i++) {
      switch (s[i]) {
        case '(':
        case '[':
        case '{':
          parens.push(s[i]);
          break;
        case ')':
          if (parens.empty() || parens.top() != '(') return false;
          parens.pop();
          break;
        case ']':
          if (parens.empty() || parens.top() != '[') return false;
          parens.pop();
          break;
        case '}':
          if (parens.empty() || parens.top() != '{') return false;
          parens.pop();
          break;
      }
    }
    return parens.empty();
  }
};
