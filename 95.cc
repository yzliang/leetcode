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
  vector<TreeNode*> generateTrees(int n) {
    return generate_trees(1, n);
  }

  vector<TreeNode*> generate_trees(int l, int r) {
    vector<TreeNode*> ret;
    if (l > r) {
      ret.push_back(NULL);
    } else if (l == r) {
      ret.push_back(new TreeNode(l));
    } else {
      for (int i = l; i <= r; i++) {
        vector<TreeNode*> left_trees = generate_trees(l, i - 1);
        vector<TreeNode*> right_trees = generate_trees(i + 1, r);
        for (int j = 0; j < left_trees.size(); j++) {
          for (int k = 0; k < right_trees.size(); k++) {
            TreeNode* root = new TreeNode(i);
            root->left = left_trees[j];
            root->right = right_trees[k];
            ret.push_back(root);
          }
        }
      }
    }
    return ret;
  }
};
