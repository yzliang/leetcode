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
  bool isSymmetric(TreeNode *root) {
    if (!root) return true;
    vector<int> order1;
    traverse1(root->left, order1);
    vector<int> order2;
    traverse2(root->right, order2);
    return order1 == order2;
  }

  void traverse1(TreeNode* root, vector<int>& order) {
    if (root) {
      traverse1(root->left, order);
      order.push_back(root->val);
      traverse1(root->right, order);
    }
  }

  void traverse2(TreeNode* root, vector<int>& order) {
    if (root) {
      traverse2(root->right, order);
      order.push_back(root->val);
      traverse2(root->left, order);
    }
  }
};
