#include <string>
#include <vector>
using namespace std;

class Solution {
public:
  int evalRPN(vector<string> &tokens) {
    vector<int> s;
    for (vector<string>::iterator it = tokens.begin(); it != tokens.end();
         it++) {
      if (*it == "+") {
        int o1 = s.back();
        s.pop_back();
        int o2 = s.back();
        s.pop_back();
        s.push_back(o2 + o1);
      } else if (*it == "-") {
        int o1 = s.back();
        s.pop_back();
        int o2 = s.back();
        s.pop_back();
        s.push_back(o2 - o1);
      } else if (*it == "*") {
        int o1 = s.back();
        s.pop_back();
        int o2 = s.back();
        s.pop_back();
        s.push_back(o2 * o1);
      } else if (*it == "/") {
        int o1 = s.back();
        s.pop_back();
        int o2 = s.back();
        s.pop_back();
        s.push_back(o2 / o1);
      } else {
        s.push_back(stoi(*it));
      }
    }
    return s.back();
  }
};
