class Solution {
public:
  double findMedianSortedArrays(int a[], int m, int b[], int n) {
    if (n + m == 0) return 0;
    if ((n + m) % 2) {
      return findKthNumber(a, m, b, n, (n + m) / 2 + 1);
    } else {
      return (findKthNumber(a, m, b, n, (n + m) / 2) +
          findKthNumber(a, m, b, n, (n + m) / 2 + 1)) / 2.0;
    }
  }

  int findKthNumber(int* a, int m, int* b, int n, int k) {
    if (m == 0) return b[k - 1];
    if (n == 0) return a[k - 1];
    // Find first b[i] >= a[m / 2].
    int b_l = 0, b_r = n - 1;
    while (b_l <= b_r) {
      int mid = (b_l + b_r) / 2;
      if (b[mid] < a[m / 2])
        b_l = mid + 1;
      else 
        b_r = mid - 1;
    }
    // Speical treatment for m == 1, b_l == 0.
    if (m == 1 && b_l == 0)
      return k == 1 ? a[0] : b[k - 2];
    else if (k <= m / 2 + b_l)
      return findKthNumber(a, m / 2, b, b_l, k);
    else
      return findKthNumber(&a[m / 2], m - m / 2, &b[b_l], n - b_l,
          k - m / 2 - b_l);
  }
};
