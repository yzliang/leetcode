#include <iostream>
#include <vector>
using namespace std;

struct Interval {
    int start;
    int end;
    Interval() : start(0), end(0) {}
    Interval(int s, int e) : start(s), end(e) {}
};

class Solution {
public:
  vector<Interval> merge(vector<Interval> &intervals) {
    int total = merge_sort(intervals, 0, intervals.size() - 1);
    intervals.resize(total);
    return intervals;
  }
  
  int merge_sort(vector<Interval>& intervals, int p, int q) {
    if (p >= q) return q - p + 1;
    int mid = (p + q) / 2;
    int num_left = merge_sort(intervals, p, mid);
    int num_right = merge_sort(intervals, mid + 1, q);
    vector<Interval> result;
    int i = p, j = mid + 1;
    while (i < p + num_left && j < mid + 1 + num_right) {
      if (intervals[i].start > intervals[j].end) {
        result.push_back(intervals[j++]);
      } else if (intervals[j].start > intervals[i].end) {
        result.push_back(intervals[i++]);
      } else {
        // Must merge.
        int start = min(intervals[i].start, intervals[j].start);
        if (intervals[i].end >= intervals[j].end) {
          intervals[i].start = start;
          j++;
        } else {
          intervals[j].start = start;
          i++;
        }
      }
    }
    while (i < p + num_left)
      result.push_back(intervals[i++]);
    while (j < mid + 1 + num_right)
      result.push_back(intervals[j++]);
    for (int i = 0; i < result.size(); i++)
      intervals[p + i] = result[i];
    return result.size();
  }
};
