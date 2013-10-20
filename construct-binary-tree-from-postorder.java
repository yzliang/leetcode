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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0,
                postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int l, int r, int[] postorder, int p,
            int q) {
        if (l > r) return null;
        if (l == r) return new TreeNode(postorder[q]);
        TreeNode node = new TreeNode(postorder[q]);
        for (int i = l; i <= r; i++) {
            if (inorder[i] == postorder[q]) {
                node.left = build(inorder, l, i - 1, postorder, p,
                        p + (i - l) - 1);
                node.right = build(inorder, i + 1, r, postorder, p + (i - l),
                        q - 1);
                break;
            }
        }
        return node;
    }
}
