/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<ArrayList<Integer>>();
        path = new ArrayList<Integer>();
        searchPath(root, path, 0, sum);
        return ans;
    }

    private void searchPath(TreeNode root, ArrayList<Integer> path, int sum,
            int target) {
        if (root == null) return;
        path.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null && sum == target)
            ans.add(new ArrayList<Integer>(path));
        searchPath(root.left, path, sum, target);
        searchPath(root.right, path, sum, target);
        path.remove(path.size() - 1);
        sum -= root.val;
    }

    private ArrayList<Integer> path;
    private ArrayList<ArrayList<Integer>> ans;
}
