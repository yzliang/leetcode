#include <cmath>
#include <cstdlib>

struct TreeLinkNode {
  int val;
  TreeLinkNode *left, *right, *next;
  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
};

class Solution {
public:
  void connect(TreeLinkNode *root) {
    TreeLinkNode* node = root;
    while (true) {
      // Find the leftmost child in the next level.
      while (node && !node->left && !node->right) {
        node = node->next;
      }
      if (!node) break;
      TreeLinkNode* tail = node->left ? node->left : node->right;
      TreeLinkNode* head = tail;
      // Connect.
      while (node) {
        if (node->left == tail && node->right) {
          tail->next = node->right;
          tail = node->right;
          continue;
        }
        node = node->next;
        while (node && !node->left && !node->right) {
          node = node->next;
        }
        if (!node) break;
        if (node->left) {
          tail->next = node->left;
          tail = node->left;
        } else {
          tail->next = node->right;
          tail = node->right;
        }
      }
      node = head;
    }
  }
};
