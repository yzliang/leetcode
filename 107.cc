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
  vector<vector<int> > levelOrderBottom(TreeNode* root) {
    vector<vector<int> > ans;
    if (!root) return ans;
    vector<int> num_level;
    vector<TreeNode*> order;
    num_level.push_back(1);
    order.push_back(root);
    int next_node = 0;
    while (true) {
      int num_next_level = 0;
      for (int i = 0; i < num_level.back(); i++) {
        TreeNode* node = order[next_node++];
        if (node->left) {
          num_next_level++;
          order.push_back(node->left);
        }
        if (node->right) {
          num_next_level++;
          order.push_back(node->right);
        }
      }
      if (num_next_level > 0) {
        num_level.push_back(num_next_level);
      } else {
        break;
      }
    }
    int last = order.size() - 1;
    for (int i = num_level.size() - 1; i >= 0; i--) {
      vector<int> ids;
      for (int j = last - num_level[i] + 1; j <= last; j++) {
        ids.push_back(order[j]->val);
      }
      ans.push_back(ids);
      last -= num_level[i];
    }
    return ans;
  }
};
