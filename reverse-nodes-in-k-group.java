public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode[] group = new ListNode[k];
        ListNode current = pre;
        while (true) {
            ListNode node = current;
            for (int i = 0; i < k; i++) {
                node = node.next;
                if (node == null) break;
                group[i] = node;
            }
            if (node == null) break;
            ListNode next = node.next;
            current.next = group[k - 1];
            for (int i = k - 1; i > 0; i--)
                group[i].next = group[i - 1];
            group[0].next = next;
            current = group[0];
        }
        return pre.next;
    }
}
