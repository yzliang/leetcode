public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int max_len = 0;
            while (max_len < ans.length() && max_len < strs[i].length() &&
                    ans.charAt(max_len) == strs[i].charAt(max_len))
                max_len++;
            ans = ans.substring(0, max_len);
        }
        return ans;
    }
}
