public class Solution {
    static final char[] one = {'I', 'X', 'C', 'M', '#'};
    static final char[] five = {'V', 'L', 'D', '#'};
    public int romanToInt(String s) {
        int val = 0;
        int l = 0, r;
        for (int i = 3; i >= 0; i--) {
            r = l;
            while (r < s.length() && (s.charAt(r) == one[i] ||
                    s.charAt(r) == five[i] || s.charAt(r) == one[i + 1])) {
                r++;
            }
            if (l == r) {
                val = val * 10;
            } else if (r - l == 2 && s.charAt(l + 1) == five[i]) {
                val = val * 10 + 4;
            } else if (r - l == 2 && s.charAt(l + 1) == one[i + 1]) {
                val = val * 10 + 9;
            } else if (s.charAt(l) == one[i]) {
                val = val * 10 + r - l;
            } else {
                val = val * 10 + 5 + r - l - 1;
            }
            l = r;
        }
        return val;
    }
}
