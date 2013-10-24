#include <queue>
#include <utility>
#include <vector>
using namespace std;

class Solution {
public:
  void solve(vector<vector<char> >& board) {
    if (board.empty()) return;
    int rows = board.size(), cols = board[0].size();
    // Flood fill from the margin: mark all marginal 'O' as 'S'.
    for (int i = 0; i < rows; i++) {
      if (board[i][0] == 'O')
        flood_fill(board, i, 0);
      if (board[i][cols - 1] == 'O')
        flood_fill(board, i, cols - 1);
    }
    for (int i = 0; i < cols; i++) {
      if (board[0][i] == 'O')
        flood_fill(board, 0, i);
      if (board[rows - 1][i] == 'O')
        flood_fill(board, rows - 1, i);
    }
    // S -> O, O -> X.
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (board[i][j] == 'S') {
          board[i][j] = 'O';
        } else if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }
  }

  void flood_fill(vector<vector<char> >& board, int x, int y) {
    static const int dx[4] = {0, 1, 0, -1};
    static const int dy[4] = {1, 0, -1, 0};
    int rows = board.size(), cols = board[0].size();
    queue<pair<int, int> > q;
    q.push(make_pair(x, y));
    board[x][y] = 'S';
    while (!q.empty()) {
      pair<int, int> head = q.front();
      q.pop();
      for (int i = 0; i < 4; i++) {
        int nx = head.first + dx[i], ny = head.second + dy[i];
        if (nx >= 0 && nx < rows && ny >= 0 && ny < cols &&
            board[nx][ny] == 'O') {
          board[nx][ny] = 'S';
          q.push(make_pair(nx, ny));
        }
      }
    }
  }
};
