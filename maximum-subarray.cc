class Solution {
public:
    int maxSubArray(int A[], int n) {
        int ans = INT_MIN, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            if (sum > ans) ans = sum;
            if (sum < 0) sum = 0;
        }
        return ans;
    }
};
