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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) return null;
        int total = 0;
        for (ListNode node = head; node != null; node = node.next)
            total++;
        n %= total;
        ListNode first = head;
        for (int i = 0; i < n; i++)
            first = first.next;
        ListNode second = head;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = head;
        head = second.next;
        second.next = null;
        return head;
    }
}
