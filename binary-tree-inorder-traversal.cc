#include <cstdlib>
#include <stack>
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
  vector<int> inorderTraversal(TreeNode *root) {
    vector<int> ans;
    if (!root) return ans;
    stack<State> states;
    states.push(State(root, 0));
    while (!states.empty()) {
      State current = states.top();
      switch (current.state) {
        case 0:
          states.top().state++;
          if (current.node->left) {
            states.push(State(current.node->left, 0));
          }
          break;
        case 1:
          states.top().state++;
          ans.push_back(current.node->val);
          if (current.node->right) {
            states.push(State(current.node->right, 0));
          }
          break;
        case 2:
          states.pop();
      }
    }
    return ans;
  }

  struct State {
    TreeNode* node;
    int state;
    State(TreeNode* n, int s) : node(n), state(s) {}
  };
};
