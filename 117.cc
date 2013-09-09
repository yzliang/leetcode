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
    int level = max_level(root);
    for (int i = 1; i < level; i++) {
      TreeLinkNode* pre_node = NULL;
      for (int j = 0; j < (1 << i); j++) {
        int code = j;
        TreeLinkNode* node = root;
        for (int k = i - 1; k >= 0; k--) {
          node = (code & (1 << k)) ? node->right : node->left;
          if (!node) break;
        }
        if (pre_node) {
          pre_node->next = node;
        }
        if (node) {
          pre_node = node;
        }
      }
    }
  }

  int max_level(TreeLinkNode* root) {
    if (!root) return 0;
    return max(max_level(root->left), max_level(root->right)) + 1;
  }
};
