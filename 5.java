public class Solution {
    public String longestPalindrome(String s) {
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            int p = i, q = i;
            while (p >= 0 && q < s.length() && s.charAt(p) == s.charAt(q)) {
                p--;
                q++;
            }
            if (q - p - 1 > r - l + 1) {
                l = p + 1;
                r = q - 1;
            }
            p = i;
            q = i + 1;
            while (p >= 0 && q < s.length() && s.charAt(p) == s.charAt(q)) {
                p--;
                q++;
            }
            if (q - p  - 1 > r - l + 1) {
                l = p + 1;
                r = q - 1;
            }
        }
        return s.substring(l, r + 1);
    }
}
