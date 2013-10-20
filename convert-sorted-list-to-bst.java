/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int len = 0;
        for (ListNode node = head; node != null; node = node.next)
            len++;
        if (len == 1) return new TreeNode(head.val);
        ListNode node = head;
        ListNode prev = null;
        for (int i = 0; i < len / 2; i++) {
            prev = node;
            node = node.next;
        }
        TreeNode root = new TreeNode(node.val);
        prev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(node.next);
        return root;
    }
}
