#include <stack>
#include <vector>
using namespace std;

class Solution {
public:
  int maximalRectangle(vector<vector<char> > &matrix) {
    if (matrix.empty() || matrix[0].empty()) return 0;
    int n = matrix.size();
    int m = matrix[0].size();
    // Compute the height of max possible rectangles from a grid.
    vector<vector<int> > height(n, vector<int>(m));
    for (int i = 0; i < m; i++) {
      height[0][i] = matrix[0][i] == '1';
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < m; j++) {
        height[i][j] = matrix[i][j] == '1' ? height[i - 1][j] + 1 : 0;
      }
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      stack<Beam> beams;
      for (int j = 0; j < m; j++) {
        while (!beams.empty() && beams.top().height > height[i][j]) {
          Beam last_beam = beams.top();
          beams.pop();
          int left_pos = beams.empty() ? 0 : beams.top().position + 1;
          int area = last_beam.height * (j - left_pos);
          if (area > ans) ans = area;
        }
        beams.push(Beam(j, height[i][j]));
      }
      while (!beams.empty()) {
        Beam last_beam = beams.top();
        beams.pop();
        int left_pos = beams.empty() ? 0 : beams.top().position + 1;
        int area = last_beam.height * (m - left_pos);
        if (area > ans) ans = area;
      }
    }
    return ans;
  }

  struct Beam {
    int position;
    int height;
    Beam(int pos, int h) : position(pos), height(h) {}
  };
};
