public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode current = pre;
        while (true) {
            ListNode next1 = current.next;
            if (next1 == null) break;
            ListNode next2 = next1.next;
            if (next2 == null) break;
            // Swap.
            next1.next = next2.next;
            current.next = next2;
            next2.next = next1;
            current = next1;
        }
        return pre.next;
    }
}
