#include <algorithm>
#include <iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
  int maxPathSum(TreeNode *root) {
    if (!root) return 0;
    int max_depth;
    return maxPath(root, &max_depth);
  }
private:
  // max_depth: max path down from the root.
  // NEGATIVE VALUES!
  int maxPath(TreeNode *root, int* max_depth) {
    int left_depth = 0, right_depth = 0;
    int left_max = 0, right_max = 0;
    if (root->left)
      left_max = maxPath(root->left, &left_depth);
    if (root->right)
      right_max = maxPath(root->right, &right_depth);
    *max_depth = max(0, max(left_depth, right_depth)) + root->val;
    int ret = root->val + max(0, left_depth) + max(0, right_depth);
    if (root->left)
      ret = max(ret, left_max);
    if (root->right)
      ret = max(ret, right_max);
    return ret;
  }
};
