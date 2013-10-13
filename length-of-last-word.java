public class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isWhitespace(s.charAt(i))) {
                if (start != -1) len = i - start;
                start = -1;
            } else {
                if (start == -1) start = i;
            }
        }
        if (start != -1) len = s.length() - start;
        return len;
    }
}
