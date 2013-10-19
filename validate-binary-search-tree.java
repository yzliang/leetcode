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
    public boolean isValidBST(TreeNode root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validate(TreeNode root, int min_value, int max_value) {
        if (root == null) return true;
        if (root.val < min_value || root.val > max_value) return false;
        return validate(root.left, min_value, root.val - 1) &&
            validate(root.right, root.val + 1, max_value);
    }
}
