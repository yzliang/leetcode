class Solution {
public:
    bool canJump(int A[], int n) {
        if (n <= 1) return true;
        int bound = 0;
        for (int i = 0; i <= bound; i++) {
            if (i + A[i] > bound) {
                bound = i + A[i];
                if (bound >= n - 1) return true;
            }
        }
        return false;
    }
};
