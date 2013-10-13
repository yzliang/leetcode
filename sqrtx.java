public class Solution {
    // Convergence determination is critical!
    public int sqrt(int x) {
        double val = 1;
        while (true) {
            double newVal = (val + x / val) / 2;
            if (Math.abs(newVal - val) < 0.1)
                return (int) newVal;
            val = newVal;
        }
    }
}
