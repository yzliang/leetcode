/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode tail = pre;
        while (head != null) {
            ListNode diff = head.next;
            while (diff != null && diff.val == head.val) diff = diff.next;
            if (diff == head.next) {
                tail.next = head;
                tail = head;
            }
            head = diff;
        }
        tail.next = null;
        return pre.next;
    }
}
