#include <vector>
using namespace std;

class Solution {
public:
  int largestRectangleArea(vector<int> &height) {
    vector<pair<int, int> > beams;
    int ans = 0;
    for (int i = 0; i < height.size(); i++) {
      while (!beams.empty() && height[i] < beams.back().second) {
        pair<int, int> last_beam = beams.back();
        beams.pop_back();
        int area = last_beam.second;
        area *= i - (beams.empty() ? 0 : beams.back().first + 1);
        if (area > ans) ans = area;
      }
      beams.push_back(make_pair(i, height[i]));
    }
    while (!beams.empty()) {
      pair<int, int> last_beam = beams.back();
      beams.pop_back();
      int area = last_beam.second;
      area *= height.size() - (beams.empty() ? 0 : beams.back().first + 1);
      if (area > ans) ans = area;
    }
    return ans;
  }
};
