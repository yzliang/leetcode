#include <cstdlib>

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
  void flatten(TreeNode *root) {
    TreeNode* head;
    TreeNode* tail;
    make_flatten(root, &head, &tail);
  }

  void make_flatten(TreeNode* root, TreeNode** head, TreeNode** tail) {
    if (!root) {
      *head = *tail = NULL;
      return;
    }
    *head = *tail = root;
    TreeNode* left_head, *left_tail, *right_head, *right_tail;
    make_flatten(root->left, &left_head, &left_tail);
    make_flatten(root->right, &right_head, &right_tail);
    bool has_left = root->left;
    bool has_right = root->right;
    root->left = NULL;
    if (has_left) {
      (*tail)->right = left_head;
      *tail = left_tail;
    }
    if (has_right) {
      (*tail)->right = right_head;
      *tail = right_tail;
    }
  }
};
