class Solution {
public:
  ListNode *deleteDuplicates(ListNode *head) {
    ListNode* prev = NULL;
    ListNode* current = head;
    while (current != NULL) {
      if (prev != NULL && prev->val == current->val) {
        prev->next = current->next;
      } else {
          prev = current;
      }
      current = current->next;
    }
    return head;
  }
};
