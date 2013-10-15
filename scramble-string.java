public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int len = s1.length();
        boolean[][][] f = new boolean[len + 1][len][len];
        for (int l = 1; l <= len; l++) {
            for (int i = 0; i + l <= len; i++) {
                for (int j = 0; j + l <= len; j++) {
                    if (s1.substring(i, i + l).equals(s2.substring(j, j + l))) {
                        f[l][i][j] = true;
                        continue;
                    }
                    for (int k = 1; k < l; k++) {
                        if (f[k][i][j] && f[l - k][i + k][j + k] ||
                                f[k][i][j + l - k] && f[l - k][i + k][j]) {
                            f[l][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[len][0][0];
    }
}
