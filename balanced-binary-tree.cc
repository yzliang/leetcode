struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
  bool isBalanced(TreeNode *root) {
    int depth;
    return check_balancing(root, &depth);
  }

  bool check_balancing(TreeNode* root, int* depth) {
    if (!root) {
      *depth = 0;
      return true;
    }
    int left_depth, right_depth;
    if (!check_balancing(root->left, &left_depth)) return false;
    if (!check_balancing(root->right, &right_depth)) return false;
    if (abs(left_depth - right_depth) > 1) return false;
    *depth = max(left_depth, right_depth) + 1;
    return true;
  }
};
