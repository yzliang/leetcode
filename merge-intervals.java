/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        ArrayList<Interval> ans = new ArrayList<Interval>();
        if (intervals.isEmpty()) return ans;
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (last.end >= current.start) {
                last = new Interval(last.start,
                        Math.max(last.end, current.end));
            } else {
                ans.add(last);
                last = current;
            }
        }
        ans.add(last);
        return ans;
    }
}
