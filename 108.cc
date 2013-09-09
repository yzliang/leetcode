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
  TreeNode *sortedArrayToBST(vector<int> &num) {
    return array_to_bst(num, 0, num.size() - 1);
  }

  TreeNode* array_to_bst(vector<int>& num, int l, int r) {
    if (l > r) return NULL;
    int mid = (l + r) / 2;
    TreeNode* root = new TreeNode(num[mid]);
    root->left = array_to_bst(num, l, mid - 1);
    root->right = array_to_bst(num, mid + 1, r);
    return root;
  }
};
