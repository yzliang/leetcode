public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if (p.isEmpty()) return s.isEmpty() ? true : false;
        // p is non-empty! Find the first non-asterisk segment.
        int start = 0;
        while (start < p.length() && p.charAt(start) == '*')
            start++;
        if (start == p.length()) return true;
        int end = start + 1;
        while (end < p.length() && p.charAt(end) != '*')
            end++;
        if (end - start > s.length()) return false;
        String segment = p.substring(start, end);
        if (start == 0) {
            if (!matchCharacters(s.substring(start, end), segment))
                return false;
            else
                return isMatch(s.substring(end), p.substring(end));
        } else if (end == p.length()) {
            return matchCharacters(s.substring(s.length() - segment.length()),
                        segment);
        } else {
            int len = end - start;
            for (int i = 0; i + len <= s.length(); i++) {
                if (matchCharacters(s.substring(i, i + len), segment))
                    return isMatch(s.substring(i + len), p.substring(end));
            }
            return false;
        }
    }

    private boolean matchCharacters(String s, String p) {
        for (int i = 0; i < s.length(); i++) {
            if (p.charAt(i) != '?' && p.charAt(i) != s.charAt(i))
                return false;
        }
        return true;
    }
}
