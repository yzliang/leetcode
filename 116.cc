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
    int level = 0;
    for (TreeLinkNode* node = root; node; node = node->left) {
      level++;
    }
    for (int i = 1; i < level; i++) {
      TreeLinkNode* pre_node = NULL;
      for (int j = 0; j < (1 << i); j++) {
        int code = j;
        TreeLinkNode* node = root;
        for (int k = i - 1; k >= 0; k--) {
          node = (code & (1 << k)) ? node->right : node->left;
        }
        if (pre_node) {
          pre_node->next = node;
        }
        pre_node = node;
      }
    }
  }
};
