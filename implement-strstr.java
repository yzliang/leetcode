public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return null;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean match = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) return haystack.substring(i);
        }
        return null;
    }
}
