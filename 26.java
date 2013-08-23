public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int total = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[total - 1] != A[i]) {
                A[total++] = A[i];
            }
        }
        return total;
    }
}
