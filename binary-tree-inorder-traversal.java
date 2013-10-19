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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<Integer>();
        go(root);
        return ans;
    }
    
    private void go(TreeNode root) {
        if (root == null) return;
        go(root.left);
        ans.add(root.val);
        go(root.right);
    }
    
    private ArrayList<Integer> ans;
}
