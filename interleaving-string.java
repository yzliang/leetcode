public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] interleave = new boolean[s1.length() + 1][s2.length() + 1];
        interleave[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (!interleave[i][j]) continue;
                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j))
                    interleave[i + 1][j] = true;
                if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j))
                    interleave[i][j + 1] = true;
            }
        }
        return interleave[s1.length()][s2.length()];
    }
}
