public class Solution {
    public int firstMissingPositive(int[] A) {
        // It must be in [1, 2, ..., A.length, A.length + 1].
        for (int i = 0; i < A.length; i++) {
            while (A[i] >= 1 && A[i] <= A.length &&  A[A[i] - 1] != A[i]) {
                // Swap A[i] and A[A[i] - 1].
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        int ans = 1;
        while (ans <= A.length && A[ans - 1] == ans) ans++;
        return ans;
    }
}
