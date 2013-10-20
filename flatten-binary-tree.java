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
    public void flatten(TreeNode root) {
        TreeNode head = new TreeNode(0);
        tail = head;
        makeFlat(root);
    }

    private void makeFlat(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = root.right = null;
        tail.right = root;
        tail = root;
        makeFlat(left);
        makeFlat(right);
    }

    private TreeNode tail;
}
