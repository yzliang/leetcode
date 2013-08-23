#include <cstdlib>
#include <vector>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
  ListNode* reverseKGroup(ListNode* head, int k) {
    ListNode* pre = new ListNode(0);
    pre->next = head;
    ListNode* current = pre;
    vector<ListNode*> nodes(k);
    while (true) {
      ListNode* next_node = current->next;
      bool complete = true;
      for (int i = 0; i < k; i++) {
        if (next_node == NULL) {
          complete = false;
          break;
        }
        nodes[i] = next_node;
        next_node = next_node->next;
      }
      if (!complete) break;
      nodes[0]->next = nodes[k - 1]->next;
      for (int i = k - 1; i > 0; i--)
        nodes[i]->next = nodes[i - 1];
      current->next = nodes[k - 1];
      current = nodes[0];
    }
    head = pre->next;
    delete pre;
    return head;
  }
};
