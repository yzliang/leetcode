#include <cstdlib>

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
  void recoverTree(TreeNode* root) {
    TreeNode* left_max = find_max(root->left);
    TreeNode* right_min = find_min(root->right);
    bool left_valid = is_valid(root->left, INT_MIN, root->val - 1);
    bool right_valid = is_valid(root->right, root->val + 1, INT_MAX);
    if (!left_valid && !right_valid) {
      int temp = left_max->val;
      left_max->val = right_min->val;
      right_min->val = temp;
    } else if ((!left_max || root->val > left_max->val) &&
        (!right_min || root->val < right_min->val)) {
      if (!left_valid) {
        recoverTree(root->left);
      } else {
        recoverTree(root->right);
      }
    } else {  // The root is swapped.
      TreeNode* bad = left_valid ? right_min : left_max;
      int temp = root->val;
      root->val = bad->val;
      bad->val = temp;
    }
  }

  TreeNode* find_max(TreeNode* root) {
    if (!root) return NULL;
    TreeNode* ret = root;
    TreeNode* sub_max = find_max(root->left);
    if (sub_max && sub_max->val > ret->val) {
      ret = sub_max;
    }
    sub_max = find_max(root->right);
    if (sub_max && sub_max->val > ret->val) {
      ret = sub_max;
    }
    return ret;
  }

  TreeNode* find_min(TreeNode* root) {
    if (!root) return NULL;
    TreeNode* ret = root;
    TreeNode* sub_min = find_min(root->left);
    if (sub_min && sub_min->val < ret->val) {
      ret = sub_min;
    }
    sub_min = find_min(root->right);
    if (sub_min && sub_min->val < ret->val) {
      ret = sub_min;
    }
    return ret;
  }

  bool is_valid(TreeNode* root, int low, int high) {
    if (!root) return true;
    return root->val >= low && root->val <= high &&
      is_valid(root->left, low, root->val - 1) &&
      is_valid(root->right, root->val + 1, high);
  }
};
