import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        HashSet<Character> chars = new HashSet<Character>();
        int start = 0, end = 0;
        int maxLength = 0;
        while (end < s.length()) {
            while (start < end && chars.contains(s.charAt(end))) {
                chars.remove(s.charAt(start++));
            }
            while (end < s.length() && !chars.contains(s.charAt(end))) {
                chars.add(s.charAt(end++));
            }
            if (end - start > maxLength) {
                maxLength = end - start;
            }
        }
        return maxLength;
    }
}
