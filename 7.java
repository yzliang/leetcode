public class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        int ret = 0;
        int val = Math.abs(x);
        while (val > 0) {
            ret = ret * 10 + val % 10;
            val /= 10;
        }
        if (x < 0) {
            ret = -ret;
        }
        return ret;
    }
}
