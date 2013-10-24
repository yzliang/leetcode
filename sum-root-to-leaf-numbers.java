class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int sumNumbers(TreeNode root) {
        return root == null ? 0 : sumNode(root, 0);
    }

    private int sumNode(TreeNode node, int num) {
        num = num * 10 + node.val;
        if (node.left == null && node.right == null) return num;
        int sum = 0;
        if (node.left != null) sum += sumNode(node.left, num);
        if (node.right != null) sum += sumNode(node.right, num);
        return sum;
    }
}
