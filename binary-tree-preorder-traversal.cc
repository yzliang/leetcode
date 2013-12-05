#include <cstdlib>
#include <vector>
using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
  vector<int> preorderTraversal(TreeNode* root) {
    vector<int> ans;
    while (root) {
      TreeNode* node = root->left;
      while (node && node->right && node->right != root)
        node = node->right;
      if (!node) {
        ans.push_back(root->val);
        root = root->right;
      } else if (!node->right) {
        ans.push_back(root->val);
        node->right = root;
        root = root->left;
      } else {
        node->right = NULL;
        root = root->right;
      }
    }
    return ans;
  }
};
