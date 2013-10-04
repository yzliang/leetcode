class Solution {
public:
  double findMedianSortedArrays(int a[], int m, int b[], int n) {
    if (n == 0 && m == 0) return 0;
    int half = (n + m) / 2;
    int l = max(0, half - n), r = min(m - 1, half);
    while (l <= r) {
      int mid = (l + r) / 2;
      if (half - mid > 0 && a[mid] < b[half - mid - 1]) {
        l = mid + 1;
      } else if (half - mid == n || a[mid] <= b[half - mid]) {
        if ((n + m) % 2) {
          return a[mid];
        } else {
          if (mid == 0) return (a[mid] + b[half - mid - 1]) / 2.0;
          if (half - mid == 0) return (a[mid] + a[mid - 1]) / 2.0;
          return (max(a[mid - 1], b[half - mid - 1]) + a[mid]) / 2.0;
        }
      } else {
        r = mid - 1;
      }
    }
    return findMedianSortedArrays(b, n, a, m);
  }
};
