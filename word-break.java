public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] can = new boolean[s.length() + 1];
        can[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= i; j++)
                if (can[j - 1] && dict.contains(s.substring(j - 1, i))) {
                    can[i] = true;
                    break;
                }
        }
        return can[s.length()];
    }
}
