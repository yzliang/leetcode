#include <cstdlib>

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
  ListNode *deleteDuplicates(ListNode *head) {
    ListNode* prev = NULL;
    ListNode* current = head;
    while (current) {
      ListNode* next_diff = current->next;
      bool duplicate = false;
      while (next_diff && current->val == next_diff->val) {
        next_diff = next_diff->next;
        duplicate = true;
      }
      if (duplicate) {
        if (prev) {
          prev->next = next_diff;
        } else {
          head = next_diff;
        }
      } else {
        prev = current;
      }
      current = next_diff;
    }
    return head;
  }
};
