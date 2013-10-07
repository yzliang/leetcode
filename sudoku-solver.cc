#include <cstring>
#include <vector>
using namespace std;

class Solution {
public:
  void solveSudoku(vector<vector<char> > &board) {
    if (board.size() != 9 || board[0].size() != 9) return;
    // Initialization.
    for (int i = 0; i < 9; i++)
      for (int j = 0; j < 9; j++) {
        block_id[i][j] = 3 * (i / 3) + j / 3;
      }
    memset(row_digit, 0, sizeof(row_digit));
    memset(col_digit, 0, sizeof(col_digit));
    memset(blk_digit, 0, sizeof(blk_digit));
    for (int i = 0; i < 9; i++)
      for (int j = 0; j < 9; j++)
        if (board[i][j] != '.') {
          row_digit[i][board[i][j] - '1'] = true;
          col_digit[j][board[i][j] - '1'] = true;
          blk_digit[block_id[i][j]][board[i][j] - '1'] = true;
        }
    search(board, 0, 0);
  }

  bool search(vector<vector<char > >& board, int r, int c) {
    if (r == 9) return true;
    if (board[r][c] != '.') {
      return search(board, c == 8 ? r + 1 : r, c == 8 ? 0 : c + 1);
    }
    for (int i = 0; i < 9; i++) {
      if (row_digit[r][i] || col_digit[c][i] || blk_digit[block_id[r][c]][i])
        continue;
      board[r][c] = '1' + i;
      row_digit[r][i] = col_digit[c][i] = blk_digit[block_id[r][c]][i] = true;
      if (search(board, c == 8 ? r + 1 : r, c == 8 ? 0 : c + 1))
        return true;
      board[r][c] = '.';
      row_digit[r][i] = col_digit[c][i] = blk_digit[block_id[r][c]][i] = false;
    }
    return false;
  }

private:
  int block_id[9][9];
  bool row_digit[9][9];
  bool col_digit[9][9];
  bool blk_digit[9][9];
};
