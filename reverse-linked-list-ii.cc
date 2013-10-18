#include <cstdlib>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
  ListNode *reverseBetween(ListNode *head, int m, int n) {
    if (m == n) return head;
    int id = 0;
    ListNode* current = head;
    ListNode* reverse_head = NULL;
    ListNode* reverse_tail = NULL;
    ListNode* reverse_pre = NULL;
    while (current) {
      id++;
      if (id < m - 1) {
        current = current->next;
      } else if (id == m - 1) {
        reverse_pre = current;
        current = current->next;
        continue;
      } else if (id == m) {
        reverse_head = reverse_tail = current;
        current = current->next;
      } else if (id > m && id < n) {
        ListNode* next = current->next;
        current->next = reverse_head;
        reverse_head = current;
        current = next;
      } else if (id == n) {
        reverse_tail->next = current->next;
        current->next = reverse_head;
        reverse_head = current;
        if (reverse_pre) {
          reverse_pre->next = reverse_head;
        } else {
          head = reverse_head;
        }
        break;
      } else {
        current = current->next;
      }
    }
    return head;
  }
};
