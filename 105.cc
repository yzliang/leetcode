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
  TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
    return build_tree(preorder, 0, preorder.size() - 1, inorder, 0,
        inorder.size() - 1);
  }

  TreeNode* build_tree(vector<int>& preorder, int l, int r,
      vector<int>& inorder, int p, int q) {
    if (l > r || p > q) return NULL;
    TreeNode* root = new TreeNode(preorder[l]);
    for (int i = p; i <= q; i++) {
      if (inorder[i] == preorder[l]) {
        int len1 = i - p;
        root->left = build_tree(preorder, l + 1, l + len1, inorder, p, i - 1);
        root->right = build_tree(preorder, l + len1 + 1, r, inorder, i + 1, q);
        return root;
      }
    }
  }
};
