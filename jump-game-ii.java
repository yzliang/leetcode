public class Solution {
    public int jump(int[] A) {
        int hi = 0, lo = 0;
        int step = 0;
        while (lo <= hi && hi < A.length - 1) {
            int new_high = hi;
            for (int i = lo; i <= hi; i++) {
                if (A[i] + i > new_high)
                    new_high = A[i] + i;
            }
            lo = hi + 1;
            hi = new_high;
            step++;
        }
        return step;
    }
}
