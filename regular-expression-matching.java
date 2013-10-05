public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if (s.isEmpty() && p.isEmpty()) return true;
        if (p.isEmpty()) return false;
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (!s.isEmpty() && match(s.charAt(0), p.charAt(0)))
                return isMatch(s.substring(1), p.substring(1));
            else
                return false;
        } else {
            if (isMatch(s, p.substring(2))) return true;
            for (int i = 0; i < s.length() && match(s.charAt(i), p.charAt(0));
                 i++) {
                if (isMatch(s.substring(i + 1), p.substring(2)))
                    return true;
            }
            return false;
        }
    }

    boolean match(char a, char b) {
        return b == '.' || a == b;
    }

    public static void main(String args[]) {
        new Solution().isMatch("ab", ".*c");
    }
}
