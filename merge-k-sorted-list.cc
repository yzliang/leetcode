#include <cstdlib>
#include <queue>
#include <vector>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class CompareListNode {
  public:
    bool operator()(ListNode*& n1, ListNode*& n2) {
      return n1->val > n2->val;
    }
};

class Solution {
public:
  // Usage of std::priority_queue!!
  ListNode* mergeKLists(vector<ListNode*>& lists) {
    // Remove NULL lists.
    int size = 0;
    for (int i = 0; i < lists.size(); i++) {
      if (lists[i] != NULL)
        lists[size++] = lists[i];
    }
    lists.resize(size);
    priority_queue<ListNode*, vector<ListNode*>, CompareListNode> queue(
        lists.begin(), lists.end());
    ListNode* head = new ListNode(0);
    ListNode* current = head;
    while (!queue.empty()) {
      ListNode* top = queue.top();
      queue.pop();
      if (top->next) queue.push(top->next);
      current->next = top;
      current = current->next;
    }
    current->next = NULL;
    return head->next;
  }
};

int main() {
  vector<ListNode*> lists;
  lists.push_back(new ListNode(1));
  Solution s;
  s.mergeKLists(lists);
  return 0;
}
