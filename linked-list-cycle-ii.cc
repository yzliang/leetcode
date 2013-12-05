struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* detectCycle(ListNode* head) {
      if (head == NULL) return NULL;
      ListNode* n1 = head;
      ListNode* n2 = head;
      int num_steps = 0;
      while (move(n2) && move(n2) && move(n1)) {
        num_steps++;
        if (n1 == n2) break;
      }
      if (n1 == NULL || n2 == NULL)
        return NULL;  // No cycle.
      n1 = head;
      while (n1 != n2) {
        move(n1);
        move(n2);
      }
      return n1;
    }

    bool move(ListNode*& node) {
      node = node->next;
      return node != NULL;
    }
};
