public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if (A == null || B == null)
            return 0;
        if (A.length == 0 && B.length == 0)
            return 0;
        int half = (A.length + B.length) / 2;
        boolean odd = (A.length + B.length) % 2 != 0;
        int l = Math.max(0, half - B.length);
        int r = Math.min(A.length - 1, half);
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid < half && A[mid] < B[half - mid - 1]) {
                l = mid + 1;
            } else if (half - mid == B.length || A[mid] <= B[half - mid]) {
                if (odd) return A[mid];
                if (mid == 0) return (A[mid] + B[half - 1]) / 2.0;
                if (mid == half) return (A[mid] + A[mid - 1]) / 2.0;
                return (A[mid] + Math.max(A[mid - 1], B[half - mid - 1])) / 2.0;
            } else {
                r = mid - 1;
            }
        }
        return findMedianSortedArrays(B, A);
    }

    public static void main(String args[]) {
        int[] a = {};
        int[] b = {1};
        new Solution().findMedianSortedArrays(a, b);
    }
}
