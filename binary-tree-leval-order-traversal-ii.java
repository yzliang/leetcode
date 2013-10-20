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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> queue =
            new ArrayList<ArrayList<TreeNode>>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (root == null) return ans;
        queue.add(new ArrayList<TreeNode>());
        queue.get(0).add(root);
        while (true) {
            ArrayList<TreeNode> lastLevel = queue.get(queue.size() - 1);
            ArrayList<TreeNode> newLevel = new ArrayList<TreeNode>();
            for (TreeNode node : lastLevel) {
                if (node.left != null) newLevel.add(node.left);
                if (node.right != null) newLevel.add(node.right);
            }
            if (newLevel.isEmpty()) break;
            queue.add(newLevel);
        }
        for (ArrayList<TreeNode> nodes : queue) {
            ArrayList<Integer> values = new ArrayList<Integer>();
            for (TreeNode node :nodes) values.add(node.val);
            ans.add(values);
        }
        Collections.reverse(ans);
        return ans;
    }
}
