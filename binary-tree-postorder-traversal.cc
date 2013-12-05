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
  vector<int> postorderTraversal(TreeNode* root) {
    vector<int> ans;
    TreeNode dummy(0);
    dummy.left = root;
    root = &dummy;
    while (root) {
      TreeNode* child = root->left;
      while (child && child->right && child->right != root)
        child = child->right;
      if (!child) {
        root = root->right;
      } else if (!child->right) {
        child->right = root;
        root = root->left;
      } else {
        child->right = NULL;
        // Output.
        int total = 0;
        for (TreeNode* node = root->left; node; node = node->right) {
          ans.push_back(node->val);
          total++;
        }
        reverse(ans.end() - total, ans.end());
        root = root->right;
      }
    }
    return ans;
  }
};
