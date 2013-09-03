/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
        vector<Interval> output;
        bool used = false;
        vector<Interval>::iterator it = intervals.begin();
        while (it != intervals.end() && it->end < newInterval.start)
            output.push_back(*it++);
        while (it != intervals.end()) {
            if (it->end < newInterval.end) {
                newInterval.start = min(newInterval.start, it->start);
                it++;
            } else {
                if (it->start > newInterval.end) {
                    output.push_back(newInterval);
                } else {
                    it->start = min(it->start, newInterval.start);
                }
                used = true;
                break;
            }
        }
        while (it != intervals.end())
            output.push_back(*it++);
        if (!used) output.push_back(newInterval);
        return output;
    }
};
