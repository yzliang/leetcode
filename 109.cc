#include <cstdlib>

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
  TreeNode *sortedListToBST(ListNode *head) {
    if (!head) return NULL;
    int len = 0;
    for (ListNode* node = head; node; node = node->next) {
      len++;
    }
    ListNode* pre_mid_node = NULL;
    ListNode* mid_node = head;
    for (int i = 0; i < (len - 1) / 2; i++) {
      pre_mid_node = mid_node;
      mid_node = mid_node->next;
    }
    if (pre_mid_node) {
      pre_mid_node->next = NULL;
    }
    TreeNode* root = new TreeNode(mid_node->val);
    if (head != mid_node) {
      root->left = sortedListToBST(head);
    }
    root->right = sortedListToBST(mid_node->next);
    return root;
  }
};
