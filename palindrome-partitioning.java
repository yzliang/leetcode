import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Precompute.
        ArrayList<ArrayList<Integer>> palIndex =
            new ArrayList<ArrayList<Integer>>(s.length());
        for (int i = 0; i < s.length(); i++) {
            palIndex.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                palIndex.get(l).add(r + 1);
                l--;
                r++;
            }
            l = i - 1;
            r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                palIndex.get(l).add(r + 1);
                l--;
                r++;
            }
        }
        // Enumerate.
        ArrayList<ArrayList<String>> partitions =
            new ArrayList<ArrayList<String>>();
        findPartition(s, 0, new ArrayList<String>(), palIndex, partitions);
        return partitions;
    }

    private void findPartition(String s, int pos,
            ArrayList<String> currentPartition,
            ArrayList<ArrayList<Integer>> palIndex,
            ArrayList<ArrayList<String>> partitions) {
        if (pos == s.length()) {
            partitions.add(new ArrayList<String>(currentPartition));
            return;
        }
        for (int nextPos : palIndex.get(pos)) {
            currentPartition.add(s.substring(pos, nextPos));
            findPartition(s, nextPos, currentPartition, palIndex, partitions);
            currentPartition.remove(currentPartition.size() - 1);
        }
    }
}
