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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode rest = head;
        for (int i = 0; i < n; i++) rest = rest.next;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode front = preHead;
        for (int i = 0; i < m - 1; i++) front = front.next;
        ListNode reverseTail = front.next;
        ListNode current = front.next;
        while (current != rest) {
            ListNode temp = current.next;
            current.next = front.next;
            front.next = current;
            current = temp;
        }
        reverseTail.next = rest;
        return preHead.next;
    }
}
