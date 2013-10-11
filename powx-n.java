public class Solution {
    public double pow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        double ans = 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n = n + 1;
                ans = 1 / x;
            }
            x = 1 / x;
            n = -n;
        }
        double power = x;
        while (n > 0) {
            if (n % 2 != 0) ans *= power;
            n >>= 1;
            power *= power;
        }
        return ans;
    }
}
