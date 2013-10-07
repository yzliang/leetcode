import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
            int target) {
        ans = new ArrayList<ArrayList<Integer>>();
        if (candidates == null || candidates.length == 0) return ans;
        // Sort and unique.
        Arrays.sort(candidates);
        int total = 1;
        for (int i = 1; i < candidates.length; i++) {
            if (candidates[i] != candidates[total - 1])
                candidates[total++] = candidates[i];
        }
        candidates = Arrays.copyOf(candidates, total);
        comb = new ArrayList<Integer>();
        search(candidates, 0, 0, target);
        return ans;
    }

    void search(int[] num, int pos, int sum, int target) {
        if (sum == target) {
            ans.add(new ArrayList<Integer>(comb));
            return;
        }
        if (target - sum < num[pos]) return;
        // Use num[pos].
        comb.add(num[pos]);
        search(num, pos, sum + num[pos], target);
        comb.remove(comb.size() - 1);
        // Don't use num[pos].
        if (pos + 1 < num.length) search(num, pos + 1, sum, target);
    }

    private ArrayList<Integer> comb;
    private ArrayList<ArrayList<Integer>> ans;

    public static void main(String args[]) {
        int[] num = {1, 2};
        new Solution().combinationSum(num, 2);
    }
}
