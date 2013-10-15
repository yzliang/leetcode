class Solution {
public:
  void merge(int A[], int m, int B[], int n) {
    for (int i = m - 1; i >= 0; i--) {
      A[n + i] = A[i];
    }
    int p = n, q = 0;
    int total = 0;
    while (p < n + m && q < n) {
      if (A[p] < B[q]) {
        A[total++] = A[p++];
      } else {
        A[total++] = B[q++];
      }
    }
    while (q < n) {
      A[total++] = B[q++];
    }
  }
};
