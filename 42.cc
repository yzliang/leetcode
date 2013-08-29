class Solution {
public:
    int trap(int A[], int n) {
        if (n == 0) return 0;
        vector<int> sum(n);
        sum[0] = A[0];
        for (int i = 1; i < n; i++) sum[i] = sum[i - 1] + A[i];
        int ans = 0;
        // Left scan.
        int peak = 0;
        for (int i = 1; i < n; i++) {
            if (A[i] < A[peak]) continue;
            ans += A[peak] * (i - peak - 1) - (sum[i - 1] - sum[peak]);
            peak = i;
        }
        // Right scan.
        int peak2 = n - 1;
        for (int i = n - 2; i >= peak; i--) {
            if (A[i] < A[peak2]) continue;
            ans += A[peak2] * (peak2 - i - 1) - (sum[peak2 - 1] - sum[i]);
            peak2 = i;
        }
        return ans;
    }
};
