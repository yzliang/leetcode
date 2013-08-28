public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Search for the lower bound.
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        int lower = l;
        // Search for the upper bound.
        l = lower;
        r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int upper = r;
        int[] ans = new int[2];
        if (lower <= upper) {
            ans[0] = lower;
            ans[1] = upper;
        } else {
            ans[0] = ans[1] = -1;
        }
        return ans;
    }
}
