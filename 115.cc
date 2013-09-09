#include <string>
#include <vector>
using namespace std;

class Solution {
public:
  int numDistinct(string S, string T) {
    if (S.empty() || T.empty()) return 0;
    vector<vector<int> > dist(S.size(), vector<int>(T.size()));
    for (int i = 0; i < S.size(); i++) {
      if (S[i] == T[0]) dist[i][0] = 1;
    }
    for (int i = 0; i < S.size(); i++) {
      for (int j = 0; j < T.size(); j++) {
        if (i + 1 < S.size())
          dist[i + 1][j] += dist[i][j];
        if (i + 1 < S.size() && j + 1 < T.size() && S[i + 1] == T[j + 1])
          dist[i + 1][j + 1] += dist[i][j];
      }
    }
    return dist[S.size() - 1][T.size() - 1];
  }
};
