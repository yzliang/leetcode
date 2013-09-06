#include <string>
#include <vector>
using namespace std;

class Solution {
public:
  bool exist(vector<vector<char> > &board, string word) {
    if (word.empty()) return false;
    for (int i = 0; i < board.size(); i++) {
      for (int j = 0; j < board[0].size(); j++) {
        if (board[i][j] == word[0]) {
          vector<vector<bool> > visit(board.size(),
              vector<bool>(board[0].size()));
          visit[i][j] = true;
          if (search(board, i, j, visit, word, 1))
            return true;
        }
      }
    }
    return false;
  }

  bool search(vector<vector<char> >& board, int x, int y,
      vector<vector<bool> >& visit, string& word, int pos) {
    static const int dx[4] = {0, 1, 0, -1};
    static const int dy[4] = {1, 0, -1, 0};
    if (pos == word.size())
      return true;
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && nx < board.size() && ny >= 0 && ny < board[0].size() &&
          word[pos] == board[nx][ny] && !visit[nx][ny]) {
        visit[nx][ny] = true;
        if (search(board, nx, ny, visit, word, pos + 1))
          return true;
        visit[nx][ny] = false;
      }
    }
    return false;
  }
};
