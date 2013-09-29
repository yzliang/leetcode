#include <unordered_map>
#include <vector>
using namespace std;

class Solution {
public:
  vector<int> twoSum(vector<int> &numbers, int target) {
    typedef unordered_map<int, int> NumberIndex;
    unordered_map<int, int> num_pos;
    for (int i = 0; i < numbers.size(); i++) {
      NumberIndex::iterator it = num_pos.find(target - numbers[i]);
      if (it != num_pos.end()) {
        vector<int> ans;
        ans.push_back(it->second + 1);
        ans.push_back(i + 1);
        return ans;
      }
      num_pos[numbers[i]] = i;
    }
  }
};
