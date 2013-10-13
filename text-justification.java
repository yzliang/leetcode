public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> ans = new ArrayList<String>();
        int i = 0;
        while (i < words.length) {
            int sumLength = words[i].length();
            int j = i + 1;
            while (j < words.length &&
                    sumLength + words[j].length() + j - i <= L) {
                sumLength += words[j].length();
                j++;
            }
            StringBuilder sb = new StringBuilder();
            if (j == words.length || j - i == 1) {
                // Left justified.
                for (int k = i; k < j; k++) {
                    if (k > i) sb.append(' ');
                    sb.append(words[k]);
                }
                while (sb.length() < L)
                    sb.append(' ');
            } else {
                // Evenly justified.
                int width = (L - sumLength) / (j - i - 1);
                int numLarger = (L - sumLength) % (j - i - 1);
                sb.append(words[i]);
                for (int k = i + 1; k < j; k++) {
                    for (int l = 0; l < width; l++)
                        sb.append(' ');
                    if (k - i <= numLarger)
                        sb.append(' ');
                    sb.append(words[k]);
                }
            }
            ans.add(sb.toString());
            i = j;
        }
        return ans;
    }
}
