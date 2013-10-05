class Solution {
    public int atoi(String str) {
        int ans = 0;
        int i = 0;
        while (i < str.length() && Character.isWhitespace(str.charAt(i)))
            i++;
        boolean negative = false;
        if (i < str.length() &&
                (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            negative = str.charAt(i) == '-';
            i++;
        }
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';
            if (negative && ans < (digit + Integer.MIN_VALUE) / 10) {
                return Integer.MIN_VALUE;
            }
            if (!negative && ans > (Integer.MAX_VALUE - digit) / 10) {
                return Integer.MAX_VALUE;
            }
            ans = ans * 10 + (negative ? -digit : digit);
            i++;
        }
        return ans;
    }
}
