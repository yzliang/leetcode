#include <vector>
using namespace std;

class Solution {
public:
  struct Element {
    int val;
    int count;
    Element(int v, int c) : val(v), count(c) {}
  };

  vector<vector<int> > subsetsWithDup(vector<int> &S) {
    vector<vector<int> > ans;
    sort(S.begin(), S.end());
    vector<Element> elements;
    int i = 0;
    while (i < S.size()) {
      int j = i + 1;
      while (j < S.size() && S[i] == S[j]) {
        j++;
      }
      elements.push_back(Element(S[i], j - i));
      i = j;
    }
    vector<Element> subset;
    search(subset, elements, 0, ans);
    return ans;
  }

  void search(vector<Element>& subset, vector<Element>& elements, int pos,
      vector<vector<int> >& ans) {
    if (pos == elements.size()) {
      ans.push_back(vector<int>());
      for (int i = 0; i < subset.size(); i++) {
        for (int j = 0; j < subset[i].count; j++) {
          ans.back().push_back(subset[i].val);
        }
      }
    } else {
      search(subset, elements, pos + 1, ans);
      for (int i = 1; i <= elements[pos].count; i++) {
        subset.push_back(Element(elements[pos].val, i));
        search(subset, elements, pos + 1, ans);
        subset.pop_back();
      }
    }
  }
};
