public class Solution {
    public int trap(int[] A) {
        if (A == null) return 0;
        int ans = 0;
        int left = 0;
        // Left -> right scanning.
        while (left < A.length) {
            int right = left + 1;
            while (right < A.length && A[right] < A[left])
                right++;
            if (right == A.length) break;
            for (int i = left + 1; i < right; i++)
                ans += A[left] - A[i];
            left = right;
        }
        // Right -> left scanning.
        int peak = left;
        int right = A.length - 1;
        while (right > peak) {
            left = right - 1;
            while (left > peak && A[left] <= A[right])
                left--;
            for (int i = left + 1; i < right; i++)
                ans += A[right] - A[i];
            right = left;
        }
        return ans;
    }
}
