#include <cstdio>

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
  ListNode* insertionSortList(ListNode* head) {
    if (!head) return NULL;
    ListNode* node = head->next;
    head->next = NULL;
    while (node) {
      ListNode* next = node->next;
      if (node->val <= head->val) {
        node->next = head;
        head = node;
      } else {
        ListNode* pre = head;
        while (pre->next && pre->next->val < node->val)
          pre = pre->next;
        node->next = pre->next;
        pre->next = node;
      }
      node = next;
    }
    return head;
  }
};
