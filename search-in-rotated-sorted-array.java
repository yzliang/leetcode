public class Solution {
    public int search(int[] A, int target) {
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] >= A[0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (target >= A[0])
            return binarySearch(A, 0, l - 1, target);
        else
            return binarySearch(A, l, A.length - 1, target);
    }

    int binarySearch(int[] A, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] < target) {
                l = mid + 1;
            } else if (A[mid] == target) {
                return mid;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
