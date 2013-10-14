#include <vector>
using namespace std;

class Solution {
public:
  vector<vector<int> > combine(int n, int k) {
    this->n = n;
    this->k = k;
    ans.clear();
    vector<int> comb(k);
    search(0, comb);
    return ans;
  }

  void search(int pos, vector<int>& comb) {
    if (pos == k) {
      ans.push_back(comb);
    } else {
      int start = pos == 0 ? 1 : comb[pos - 1] + 1;
      for (int i = start; i <= n; i++) {
        comb[pos] = i;
        search(pos + 1, comb);
      }
    }
  }
private:
  vector<vector<int> > ans;
  int n, k;
};
