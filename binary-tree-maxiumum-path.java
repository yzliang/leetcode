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

    public int maxPathSum(TreeNode root) {
        return compute(root)[0];
    }

    /** return two values:
     *    1) all max path sum.
     *    2) max path sum from the root to a leaf.
     */
    private int[] compute(TreeNode root) {
        if (root == null) return new int[]{Integer.MIN_VALUE,
            Integer.MIN_VALUE};
        int[] leftSum = compute(root.left);
        int[] rightSum = compute(root.right);
        int[] sum = new int[2];
        sum[0] = Math.max(leftSum[0], rightSum[0]);
        int sumOverRoot = root.val + Math.max(0, leftSum[1]) +
            Math.max(0, rightSum[1]);
        if (sumOverRoot > sum[0]) sum[0] = sumOverRoot;
        sum[1] = root.val + Math.max(0, Math.max(leftSum[1], rightSum[1]));
        return sum;
    }
}
