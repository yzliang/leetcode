public class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0) return false;
        int len = 0;
        for (int val = x; val > 0; val /= 10) {
            len++;
        }
        int high = x, low = 0;
        for (int i = 0; i < len / 2; i++) {
            low = low * 10 + high % 10;
            high /= 10;
        }
        if (len % 2 != 0) {
            high /= 10;
        }
        return high == low;
    }
}
