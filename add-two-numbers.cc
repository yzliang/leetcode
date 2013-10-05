#include <cstdlib>

struct ListNode {
  int val;
  ListNode* next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
  ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
    if (l1 == NULL && l2 == NULL) return new ListNode(0);
    ListNode* head = new ListNode(0);
    ListNode* current = head;
    int carry = 0;
    while (l1 || l2) {
      int val = (l1 ? l1->val : 0) + (l2 ? l2->val : 0) + carry;
      carry = val / 10;
      val %= 10;
      current->next = new ListNode(val);
      current = current->next;
      if (l1) l1 = l1->next;
      if (l2) l2 = l2->next;
    }
    if (carry > 0)
      current->next = new ListNode(carry);
    current = head->next;
    delete head;
    return current;
  }
};
