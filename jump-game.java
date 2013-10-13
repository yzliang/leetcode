public class Solution {
    public boolean canJump(int[] A) {
        int lo = 0, hi = 0;
        while (lo < A.length && lo <= hi) {
            if (lo + A[lo] > hi) hi = lo + A[lo];
            lo++;
        }
        return hi >= A.length - 1;
    }
}
