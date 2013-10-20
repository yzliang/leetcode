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
  TreeNode *buildTree(vector<int>& inorder, vector<int>& postorder) {
    return build_tree(inorder, 0, inorder.size() - 1, postorder, 0,
                      postorder.size() - 1);
  }

  TreeNode* build_tree(vector<int>& inorder, int l, int r,
                       vector<int>& postorder, int p, int q) {
    if (l > r || p > q) return NULL;
    for (int i = l; i <= r; i++) {
      if (inorder[i] == postorder[q]) {
        int left_len = i - l;
        TreeNode* root = new TreeNode(postorder[q]);
        root->left = build_tree(inorder, l, i - 1, postorder, p,
                                p + left_len - 1);
        root->right = build_tree(inorder, i + 1, r, postorder, p + left_len,
                                 q - 1);
        return root;
      }
    }
  }
};
