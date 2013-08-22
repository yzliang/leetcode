import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> triplets =
            new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) return triplets;
        // Count.
        HashMap<Integer, Integer> numCount = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            Integer count = numCount.get(num[i]);
            numCount.put(num[i], count == null ? 1 : count + 1);
        }
        // Sort and unique.
        Arrays.sort(num);
        int total = 1;
        for (int i = 1; i < num.length; i++) {
            if (num[i] != num[total - 1]) {
                num[total++] = num[i];
            }
        }
        // Find triplets.
        for (int i = 0; i < total; i++) {
            for (int j = i; j < total; j++) {
                int k = 0 - num[i] - num[j];
                if (k < num[j]) continue;
                if (!numCount.containsKey(k)) continue;
                // Validatation.
                Integer common = null;
                if (num[i] == num[j] || num[i] == k) common = num[i];
                if (num[j] == k) common = num[j];
                if (common != null) {
                    Integer freq = numCount.get(common);
                    if (freq == null) continue;
                    if (common == 0 && freq < 3) continue;
                    if (freq < 2) continue;
                }
                ArrayList<Integer> triplet = new ArrayList<Integer>(3);
                triplet.add(num[i]);
                triplet.add(num[j]);
                triplet.add(k);
                triplets.add(triplet);
            }
        }
        return triplets;
    }
}
