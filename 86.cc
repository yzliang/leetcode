#include <cstdlib>

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
  ListNode *partition(ListNode *head, int x) {
    ListNode* less_head = NULL;
    ListNode* greater_head = NULL;
    ListNode* less_tail = NULL;
    ListNode* greater_tail = NULL;
    ListNode* current = head;
    while (current) {
      if (current->val < x) {
        if (less_tail) {
          less_tail->next = current;
          less_tail = current;
        } else {
          less_head = less_tail = current;
        }
      } else {
        if (greater_tail) {
          greater_tail->next = current;
          greater_tail = current;
        } else {
          greater_head = greater_tail = current;
        }
      }
      current = current->next;
    }
    if (greater_tail) {
      greater_tail->next = NULL;
    }
    if (less_head) {
      less_tail->next = greater_head;
      return less_head;
    } else {
      return greater_head;
    }
  }
};
