#include <cstdlib>

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
  bool isValidBST(TreeNode *root) {
    return verify(root, INT_MIN, INT_MAX);
  }

  bool verify(TreeNode* root, int low, int high) {
    if (!root) return true;
    return root->val >= low && root->val <= high &&
      verify(root->left, low, root->val - 1) &&
      verify(root->right, root->val + 1, high);
  }
};
