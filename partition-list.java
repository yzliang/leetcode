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
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0), lessTail = lessHead;
        ListNode greaterHead = new ListNode(0), greaterTail = greaterHead;
        while (head != null) {
            if (head.val < x) {
                lessTail.next = head;
                lessTail = head;
            } else {
                greaterTail.next = head;
                greaterTail = head;
            }
            head = head.next;
        }
        lessTail.next = greaterHead.next;
        greaterTail.next = null;
        return lessHead.next;
    }
}
