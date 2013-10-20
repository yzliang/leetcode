#include <queue>
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
  vector<vector<int> > levelOrder(TreeNode *root) {
    vector<vector<int> > ans;
    if (!root) return ans;
    queue<TreeNode*> nodes;
    nodes.push(root);
    int num = 1;
    while (num) {
      int num_next_level = 0;
      vector<int> current;
      for (int i = 0; i < num; i++) {
        TreeNode* node = nodes.front();
        nodes.pop();
        current.push_back(node->val);
        if (node->left) {
          nodes.push(node->left);
          num_next_level++;
        }
        if (node->right) {
          nodes.push(node->right);
          num_next_level++;
        }
      }
      ans.push_back(current);
      num = num_next_level;
    }
    return ans;
  }
};
