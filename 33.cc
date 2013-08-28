class Solution {
public:
    int search(int A[], int n, int target) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] < A[0])
                r = mid - 1;
            else
                l = mid + 1;
        }
        if (target < A[0]) {
            l = r + 1;
            r = n - 1;
        } else {
            l = 0;
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == target)
                return mid;
            else if (A[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
};
