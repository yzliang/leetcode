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
        TreeLinkNode head = root;
        while (head != null) {
            TreeLinkNode newHead = null;
            TreeLinkNode newTail = null;
            while (head != null) {
                if (head.left != null) {
                    if (newHead == null) {
                        newHead = newTail = head.left;
                    } else {
                        newTail.next = head.left;
                        newTail = head.left;
                    }
                }
                if (head.right != null) {
                    if (newHead == null) {
                        newHead = newTail = head.right;
                    } else {
                        newTail.next = head.right;
                        newTail = head.right;
                    }
                }
                head = head.next;
            }
            head = newHead;
        }
    }
}
