/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        ArrayList<TreeLinkNode> nodes = new ArrayList<TreeLinkNode>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            ArrayList<TreeLinkNode> nextNodes = new ArrayList<TreeLinkNode>();
            for (TreeLinkNode node : nodes) {
                if (node.left != null) nextNodes.add(node.left);
                if (node.right != null) nextNodes.add(node.right);
            }
            for (int i = 0; i < nextNodes.size() - 1; i++)
                nextNodes.get(i).next = nextNodes.get(i + 1);
            nodes = nextNodes;
        }
    }
}
