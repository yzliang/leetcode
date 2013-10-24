/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<Integer, RandomListNode> nodes =
            new HashMap<Integer, RandomListNode>();
        // Copy w/o random pointers.
        RandomListNode prev = null;
        for (RandomListNode node = head; node != null; node = node.next) {
            RandomListNode copy = new RandomListNode(node.label);
            if (prev != null) prev.next = copy;
            prev = copy;
            nodes.put(node.label, copy);
        }
        // Copy random pointers.
        for (RandomListNode node = head; node != null; node = node.next) {
            RandomListNode pointee = node.random;
            if (pointee != null)
                nodes.get(node.label).random = nodes.get(pointee.label);
        }
        return head == null ? null : nodes.get(head.label);
    }
}
