public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num,
            int target) {
        ans = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        combination = new ArrayList<Integer>();
        search(num, 0, 0, target);
        return ans;
    }

    void search(int[] num, int pos, int sum, int target) {
        if (sum == target) {
            ans.add(new ArrayList<Integer>(combination));
            return;
        }
        if (pos == num.length || num[pos] + sum > target) return;
        // Find duplicates.
        int next = pos + 1;
        while (next < num.length && num[next] == num[pos])
            next++;
        int newSum = sum;
        for (int i = pos; i < next; i++) {
            newSum += num[pos];
            if (newSum > target) break;
            combination.add(num[pos]);
            search(num, next, newSum, target);
        }
        // Backtracking.
        while (!combination.isEmpty() &&
                combination.get(combination.size() - 1) == num[pos])
            combination.remove(combination.size() - 1);
        // Skip this number.
        search(num, next, sum, target);
    }

    private ArrayList<Integer> combination;
    private ArrayList<ArrayList<Integer>> ans;
}
