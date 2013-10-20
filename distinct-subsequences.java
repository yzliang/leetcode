public class Solution {
    public int numDistinct(String S, String T) {
        int[][] num = new int[S.length() + 1][T.length() + 1];
        num[0][0] = 1;
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j <= T.length(); j++) {
                if (num[i][j] == 0) continue;
                num[i + 1][j] += num[i][j];
                if (j < T.length() && S.charAt(i) == T.charAt(j))
                    num[i + 1][j + 1] += num[i][j];
            }
        }
        return num[S.length()][T.length()];
    }
}
