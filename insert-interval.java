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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals,
            Interval newInterval) {
        ArrayList<Interval> ans = new ArrayList<Interval>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            ans.add(intervals.get(i++));
        while (i < intervals.size()
                && intervals.get(i).start <= newInterval.end) {
            int newStart = Math.min(newInterval.start, intervals.get(i).start);
            int newEnd = Math.max(newInterval.end, intervals.get(i).end);
            newInterval = new Interval(newStart, newEnd);
            i++;
        }
        ans.add(newInterval);
        if (i < intervals.size())
            ans.addAll(intervals.subList(i, intervals.size()));
        return ans;
    }
}
