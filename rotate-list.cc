/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *rotateRight(ListNode *head, int k) {
        if (!head) return NULL;
        int len = 0;
        for (ListNode* p = head; p; p = p->next)
            len++;
        k %= len;
        ListNode* pre = new ListNode(0);
        pre->next = head;
        ListNode* first = pre;
        for (int i = 0; i < k; i++)
            first = first->next;
        ListNode* second = pre;
        while (first->next) {
            first = first->next;
            second = second->next;
        }
        first->next = head;
        head = second->next;
        second->next = NULL;
        delete pre;
        return head;
    }
};
