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
    public void recoverTree(TreeNode root) {
        first = second = previous = null;
        firstError = true;
        // Morris traversal.
        while (root != null) {
            if (root.left == null) {
                visit(root);
                root = root.right;
                continue;
            }
            TreeNode pred = root.left;  // Predecessor.
            while (pred.right != null && pred.right != root)
                pred = pred.right;
            if (pred.right == null) {
                pred.right = root;
                root = root.left;
            } else {
                pred.right = null;
                visit(root);
                root = root.right;
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void visit(TreeNode node) {
        if (previous != null && previous.val > node.val) {
            if (firstError) {
                first = previous;
                second = node;
                firstError = false;
            } else {
                second = node;
            }
        }
        previous = node;
    }

    private TreeNode first;
    private TreeNode second;
    private TreeNode previous;
    private boolean firstError;
}
