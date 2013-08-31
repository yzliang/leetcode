class Solution {
public:
    double pow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        return compute(x, n);
    }
    
    double compute(double x, int n) {
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double ret = compute(x, n / 2);
        ret *= ret;
        if (n % 2) ret *= n > 0 ? x : 1 / x;
        return ret;
    }
};
