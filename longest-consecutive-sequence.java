public class Solution {
    public int longestConsecutive(int[] num) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int i : num) numSet.add(i);
        int bestLow = 0, bestHigh = -1;
        for (int i = 0; i < num.length; i++) {
            // num[i] is in the currently best subsequence.
            if (num[i] >= bestLow && num[i] <= bestHigh) continue;
            int low, high;
            for (low = num[i]; numSet.contains(low - 1); low--);
            for (high = num[i]; numSet.contains(high + 1); high++);
            if (high - low > bestHigh - bestLow) {
                bestLow = low;
                bestHigh = high;
            }
        }
        return bestHigh - bestLow + 1;
    }
}
