public class Solution {

    private static class State {
        String word;
        int length;

        public State(String w, int l) {
            word = w;
            length = l;
        }
    }

    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<State> queue = new LinkedList<State>();
        queue.offer(new State(start, 1));
        HashSet<String> visit = new HashSet<String>();
        visit.add(start);
        while (!queue.isEmpty()) {
            State head = queue.poll();
            char[] chars = head.word.toCharArray();
            // Generate kids.
            for (int i = 0; i < head.word.length(); i++) {
                char temp = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (chars[i] == c) continue;
                    chars[i] = c;
                    String newWord = new String(chars);
                    if (newWord.equals(end)) return head.length + 1;
                    if (!dict.contains(newWord) || visit.contains(newWord))
                        continue;
                    visit.add(newWord);
                    queue.add(new State(newWord, head.length + 1));
                }
                chars[i] = temp;
            }
        }
        return 0;
    }
}
