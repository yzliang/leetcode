/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
    
    private ArrayList<TreeNode> generate(int p, int q) {
        ArrayList<TreeNode> ans = new ArrayList<TreeNode>();
        if (p > q) {
            ans.add(null);
            return ans;
        } else if (p == q) {
            ans.add(new TreeNode(p));
            return ans;
        }
        for (int i = p; i <= q; i++) {
            ArrayList<TreeNode> lefts = generate(p, i - 1);
            ArrayList<TreeNode> rights = generate(i + 1, q);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}
