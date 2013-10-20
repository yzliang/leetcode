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
    public boolean isBalanced(TreeNode root) {
        balanced = true;
        check(root);
        return balanced;
    }

    private int check(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = check(node.left);
        int rightHeight = check(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1) balanced = false;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private boolean balanced;
}
