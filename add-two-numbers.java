class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pre = new ListNode(0);
        ListNode current = pre;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) sum += l1.val;
            if (l2 != null) sum += l2.val;
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) current.next = new ListNode(carry);
        return pre.next;
    }
}
