#include <cstdlib>

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
  ListNode* sortList(ListNode* head) {
    if (!head || !head->next) return head;
    // Partition.
    ListNode* l1 = head, *l2 = head->next;
    ListNode* t1 = l1, *t2 = l2;
    ListNode* node = head->next->next;
    while (node) {
      t1->next = node;
      t1 = node;
      node = node->next;
      if (!node) break;
      t2->next = node;
      t2 = node;
      node = node->next;
    }
    t1->next = NULL;
    t2->next = NULL;
    // Sort.
    l1 = sortList(l1);
    l2 = sortList(l2);
    // Merge.
    head = t1 = NULL;
    while (l1 || l2) {
      if (l1 && (!l2 || l1->val <= l2->val)) {
        if (!head)
          head = t1 = l1;
        else {
          t1->next = l1;
          t1 = l1;
        }
        l1 = l1->next;
      } else {
        if (!head)
          head = t1 = l2;
        else {
          t1->next = l2;
          t1 = l2;
        }
        l2 = l2->next;
      }
    }
    t1->next = NULL;
    return head;
  }
};
