#include <cstdlib>
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
  vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
    vector<vector<int> > ans;
    if (!root) return ans;
    queue<TreeNode*> nodes;
    nodes.push(root);
    int num = 1;
    bool forward = true;
    while (num > 0) {
      int num_next_level = 0;
      vector<int> current_nodes;
      for (int i = 0; i < num; i++) {
        TreeNode* node = nodes.front();
        nodes.pop();
        current_nodes.push_back(node->val);
        if (node->left) {
          nodes.push(node->left);
          num_next_level++;
        }
        if (node->right) {
          nodes.push(node->right);
          num_next_level++;
        }
      }
      num = num_next_level;
      if (!forward) {
        reverse(current_nodes.begin(), current_nodes.end());
      }
      forward = !forward;
      ans.push_back(current_nodes);
    }
    return ans;
  }
};
