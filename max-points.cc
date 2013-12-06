#include <algorithm>
#include <functional>
#include <unordered_map>
#include <utility>
#include <vector>
using namespace std;

struct Point {
    int x;
    int y;
    Point() : x(0), y(0) {}
    Point(int a, int b) : x(a), y(b) {}
};

namespace std {
  template<>
  struct hash<pair<int, int> > {
    const hash<int> int_hash;
    size_t operator()(const pair<int, int>& p) const {
      size_t h1 = int_hash(p.first);
      size_t h2 = int_hash(p.second);
      return h2 + 0x9e3779b9 + (h1 << 6) + (h1 >> 2);
    }
  };
}

int gcd(int a, int b) {
  int temp;
  while (b > 0) {
    int temp = b;
    b = a % b;
    a = temp;
  }
  return a;
}

void unify(pair<int, int>& slope) {
  if (slope.first == 0) {
    slope.second = 1;
  } else {
    if (slope.first < 0) {
      slope.first = -slope.first;
      slope.second = -slope.second;
    }
    int d = gcd(abs(slope.second), slope.first);
    slope.first /= d;
    slope.second /= d;
  }
}

class Solution {
public:
  int maxPoints(vector<Point> &points) {
    int ans = 0;
    for (int i = 0; i < points.size(); i++) {
      unordered_map<pair<int, int>, int> slope_count;
      pair<int, int> slope;
      int duplicate = 0, max_count = 0;
      for (int j = 0; j < points.size(); j++) {
        if (j == i) continue;
        slope.first = points[j].x - points[i].x;
        slope.second = points[j].y - points[i].y;
        if (slope.first == 0 && slope.second == 0) {
          duplicate++;
        } else {
          unify(slope);
          max_count = max(max_count, ++slope_count[slope]);
        }
      }
      ans = max(ans, max_count + duplicate + 1);
    }
    return ans;
  }
};
