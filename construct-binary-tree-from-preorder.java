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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0,
                inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int l, int r, int[] inorder, int p,
            int q) {
        if (l > r) return null;
        if (l == r) return new TreeNode(preorder[l]);
        TreeNode node = new TreeNode(preorder[l]);
        for (int i = p; i <= q; i++) {
            if (preorder[l] == inorder[i]) {
                node.left = build(preorder, l + 1, l + (i - p), inorder, p,
                        i - 1);
                node.right = build(preorder, l + (i - p) + 1, r, inorder, i + 1,
                        q);
                break;
            }
        }
        return node;
    }
}
