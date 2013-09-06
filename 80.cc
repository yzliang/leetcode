class Solution {
public:
  int removeDuplicates(int A[], int n) {
    int i = 0;
    int total = 0;
    while (i < n) {
      int j = i + 1;
      while (j < n && A[j] == A[i]) {
        j++;
      }
      if (j - i == 1) {
        A[total++] = A[i];
      } else {
        A[total++] = A[i];
        A[total++] = A[i];
      }
      i = j;
    }
    return total;
  }
};
