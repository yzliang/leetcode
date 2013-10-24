public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        boolean[] can = new boolean[s.length() + 1];
        can[0] = true;
        ArrayList<ArrayList<Integer>> prevList =
            new ArrayList<ArrayList<Integer>>(s.length() + 1);
        prevList.add(new ArrayList<Integer>());  // Dummy placeholder.
        for (int i = 1; i <= s.length(); i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int j = 1; j <= i; j++) {
                if (can[j - 1] && dict.contains(s.substring(j - 1, i))) {
                    can[i] = true;
                    list.add(j - 1);
                }
            }
            prevList.add(list);
        }
        sentences = new ArrayList<String>();
        generate(s, s.length(), prevList, new ArrayList<String>());
        return sentences;
    }

    private void generate(String s, int pos,
            ArrayList<ArrayList<Integer>> prevList, ArrayList<String> words) {
        if (pos == 0) {
            StringBuilder sb = new StringBuilder(words.get(words.size() - 1));
            for (int i = words.size() - 2; i >= 0; i--) {
                sb.append(' ');
                sb.append(words.get(i));
            }
            sentences.add(sb.toString());
            return;
        }
        for (int prev : prevList.get(pos)) {
            words.add(s.substring(prev, pos));
            generate(s, prev, prevList, words);
            words.remove(words.size() - 1);
        }
    }

    private ArrayList<String> sentences;
}
