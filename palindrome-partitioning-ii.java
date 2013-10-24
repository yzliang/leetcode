public class Solution {
    public int minCut(String s) {
        if (s == null || s.isEmpty()) return 0;
        boolean[][] pal = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            int l = i - 1, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
                pal[l--][r++] = true;
            l = r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
                pal[l--][r++] = true;
        }
        int[] cut = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cut[i] = pal[0][i] ? 0 : i;
            for (int j = 0; j < i; j++) {
                if (pal[j + 1][i] && cut[j] + 1 < cut[i])
                    cut[i] = cut[j] + 1;
            }
        }
        return cut[s.length() - 1];
    }
}
