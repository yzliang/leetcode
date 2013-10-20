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
  vector<vector<int> > pathSum(TreeNode *root, int sum) {
    vector<vector<int> > ans;
    vector<int> path;
    search_paths(root, sum, path, ans);
    return ans;
  }

  void search_paths(TreeNode* root, int sum, vector<int>& path,
                    vector<vector<int> >& ans) {
    if (!root) return;
    path.push_back(root->val);
    sum -= root->val;
    if (!root->left && !root->right) {
      if (sum == 0) ans.push_back(path);
    } else {
      if (root->left) search_paths(root->left, sum, path, ans);
      if (root->right) search_paths(root->right, sum, path, ans);
    }
    path.pop_back();
  }
};
