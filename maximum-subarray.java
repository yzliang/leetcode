public class Solution {
    public int maxSubArray(int[] A) {
        int ans = Integer.MIN_VALUE;
        int val = 0;
        for (int elem : A) {
            val += elem;
            if (val > ans) ans = val;
            if (val < 0) val = 0;
        }
        return ans;
    }
}
