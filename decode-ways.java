public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) return 0;
        for (int i = 0; i < s.length(); i++)
            if (!Character.isDigit(s.charAt(i))) return 0;
        int[] num = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0')
                num[i] += i > 0 ? num[i - 1] : 1;
            if (i > 0) {
                int val = Integer.parseInt(s.substring(i - 1, i + 1));
                if (val >= 10 && val <= 26)
                    num[i] += i > 1 ? num[i - 2] : 1;
            }
        }
        return num[s.length() - 1];
    }
}
