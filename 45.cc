#include <iostream>
using namespace std;

class Solution {
public:
    int jump(int A[], int n) {
        int lo = 0, hi = 0;
        int step = 0;
        while (hi < n - 1) {
            int new_hi = 0;
            for (int i = lo; i <= hi; i++) {
                if (A[i] + i >= new_hi)
                    new_hi = A[i] + i;
            }
            cout << new_hi << endl;
            lo = hi + 1;
            hi = new_hi;
            step++;
        }
        return step;
    }
};

int main() {
  int a[] = {1, 2};
  Solution s;
  s.jump(a, 2);
  return 0;
}
