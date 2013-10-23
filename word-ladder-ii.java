public class Solution {

    private static class State {
        String word;
        State parent;

        public State(String w, State p) {
            word = w;
            parent = p;
        }
    }

    public ArrayList<ArrayList<String>> findLadders(String start, String end,
            HashSet<String> dict) {
        // Generate word graph.
        dict.add(start);
        dict.add(end);
        Map<String, ArrayList<String>> graph =
            new HashMap<String, ArrayList<String>>();
        for (String word : dict) {
            char[] chars = word.toCharArray();
            ArrayList<String> neighbor = new ArrayList<String>();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String newWord = new String(chars);
                    if (dict.contains(newWord)) neighbor.add(newWord);
                }
                chars[i] = temp;
            }
            graph.put(word, neighbor);
        }
        Queue<State> queue = new ArrayDeque<State>();
        queue.add(new State(start, null));
        Set<String> visit = new HashSet<String>();
        visit.add(start);
        // Level-by-level BFS.
        while (!queue.isEmpty() && !visit.contains(end)) {
            int size = queue.size();
            for (; size > 0; size--) {
                State state = queue.poll();
                for (String newWord : graph.get(state.word)) {
                    if (!visit.contains(newWord))
                        queue.offer(new State(newWord, state));
                }
            }
            // Add new words in the current level to the visited set.
            for (State state : queue) visit.add(state.word);
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        for (State state : queue) {
            if (!state.word.equals(end)) continue;
            ArrayList<String> path = new ArrayList<String>();
            State current = state;
            while (current != null) {
                path.add(current.word);
                current = current.parent;
            }
            Collections.reverse(path);
            ans.add(path);
        }
        return ans;
    }
}
