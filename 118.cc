#include <vector>
using namespace std;

class Solution {
public:
  vector<vector<int> > generate(int numRows) {
    vector<vector<int> > tri;
    for (int i = 1; i <= numRows; i++) {
      tri.push_back(vector<int>(i));
      tri[i - 1][0] = tri[i - 1][i - 1] = 1;
      for (int j = 1; j < i - 1; j++) {
        tri[i - 1][j] = tri[i - 2][j - 1] + tri[i - 2][j];
      }
    }
    return tri;
  }
};
