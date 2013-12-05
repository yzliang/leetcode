struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    bool hasCycle(ListNode *head) {
      if (head == NULL) return false;
      ListNode* n1 = head;
      ListNode* n2 = head;
      while (move(&n2) && move(&n2) && move(&n1)) {
        if (n1 == n2) return true;
      }
      return false;
    }

    bool move(ListNode** ppn) {
      if ((*ppn)->next) {
        *ppn = (*ppn)->next;
        return true;
      }
      return false;
    }
};
