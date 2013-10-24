public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] delta = new int[n];
        for (int i = 0; i < n; i++)
            delta[i] = gas[i] - cost[i];
        int start = 0, end = 0;
        int len = 0;
        int sum = 0;
        while (len < n) {
            // Extend the tail by one.
            sum += delta[end];
            end = (end + 1) % n;
            len++;
            if (sum < 0) {
                if (end <= start) return -1;
                start = end;
                sum = len = 0;
                continue;
            }
        }
        return start;
    }
}
