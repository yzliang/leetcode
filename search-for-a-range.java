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
        if (lower <= upper) {
            return new int[]{lower, upper};
        } else {
            return new int[]{-1, -1};
        }
    }
}
