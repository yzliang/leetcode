import java.util.ArrayList;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    static class ListHead implements Comparable<ListHead> {
        ListNode node;

        public int compareTo(ListHead that) {
            int val1 = node == null ? Integer.MAX_VALUE : node.val;
            int val2 = that.node == null ? Integer.MAX_VALUE : that.node.val;
            if (val1 < val2) return -1;
            if (val1 > val2) return 1;
            return 0;
        }

        ListHead(ListNode node) {
            this.node = node;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) return null;
        PriorityQueue<ListHead> queue = new PriorityQueue<ListHead>();
        for (ListNode list : lists)
            queue.add(new ListHead(list));
        ListNode pre = new ListNode(0);
        ListNode current = pre;
        while (queue.peek().node != null) {
            ListHead top = queue.poll();
            current.next = top.node;
            current = top.node;
            top.node = top.node.next;
            queue.add(top);
        }
        return pre.next;
    }
}
