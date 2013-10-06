public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 0) return 0;
        boolean negative = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if (divisor < 0) {
            if (divisor == Integer.MIN_VALUE)
                return dividend == Integer.MIN_VALUE ? 1 : 0;
            divisor = -divisor;
        }
        if (dividend < 0) {
            if (dividend == Integer.MIN_VALUE) {
                dividend += divisor;
                result++;
            }
            dividend = -dividend;
        }
        while (dividend >= divisor) {
            int times = 1;
            int multiple = divisor;
            while ((dividend >> 1) >= multiple) {
                multiple <<= 1;
                times <<= 1;
            }
            dividend -= multiple;
            result += times;
        }
        return negative ? -result : result;
    }
}
