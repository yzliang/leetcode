public class Solution {
    public int singleNumber(int[] A) {
        int l = 0, r = A.length - 1;
        while (true) {
            int pivot = A[(l + r) / 2];
            int low = l;
            for (int i = l; i <= r; i++)
                if (A[i] < pivot) swap(A, i, low++);
            int high = r;
            for (int i = r; i >= low; i--)
                if (A[i] > pivot) swap(A, i, high--);
            // less than: [l, low), equal: [low, high], greater: (high, r]
            if (high == low) return A[low];
            if ((low - l) % 3 == 0)
                l = high + 1;
            else
                r = low - 1;
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
