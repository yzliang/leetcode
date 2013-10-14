public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ans = new ArrayList<ArrayList<Integer>>();
        int[] nums = new int[k];
        search(nums, 1, n, k);
        return ans;
    }

    private void search(int[] nums, int low, int n, int k) {
        if (k == 0) {
            ArrayList<Integer> list = new ArrayList<Integer>(nums.length);
            for (int num : nums) list.add(num);
            ans.add(list);
            return;
        }
        if (n - low + 1 < k) return;
        nums[nums.length - k] = low;
        search(nums, low + 1, n, k - 1);
        search(nums, low + 1, n, k);
    }
    
    private ArrayList<ArrayList<Integer>> ans;
}
