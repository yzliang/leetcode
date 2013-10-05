public class Solution {
    public String convert(String s, int nRows) {
        if (nRows == 1) return s;
        StringBuilder ans = new StringBuilder();
        int stepSize = nRows + nRows - 2;
        for (int i = 0; i < s.length(); i += stepSize)
            ans.append(s.charAt(i));
        for (int i = 1; i < nRows - 1; i++) {
            for (int j = i; j < s.length(); j += stepSize) {
                ans.append(s.charAt(j));
                if (j + 2 * (nRows - 1 - i) < s.length())
                    ans.append(s.charAt(j + 2 * (nRows - 1 - i)));
            }
        }
        for (int i = nRows - 1; i < s.length(); i += stepSize)
            ans.append(s.charAt(i));
        return ans.toString();
    }
}
