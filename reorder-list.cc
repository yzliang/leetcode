struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    void reorderList(ListNode *head) {
      if (head == NULL || head->next == NULL) return;
      int len = 0;
      for (ListNode* node = head; node != NULL; node = node->next)
        len++;
      ListNode* tail = head;
      for (int i = 0; i < len / 2; i++)
        tail = tail->next;
      // Split into two lists.
      ListNode* head2 = NULL;
      ListNode* node = tail->next;
      while (node != NULL) {
        ListNode* temp = node->next;
        node->next = head2;
        head2 = node;
        node = temp;
      }
      tail->next = NULL;
      // Merge back.
      while (head2 != NULL) {
        ListNode* node1 = head;
        ListNode* node2 = head2;
        head = head->next;
        head2 = head2->next;
        node1->next = node2;
        node2->next = head;
      }
    }
};
