public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        for (int i = m - 1; i >= 0; i--) A[A.length - (m - i)] = A[i];
        int i = A.length - m;
        int j = 0;
        int total = 0;
        while (i < A.length && j < n) {
            if (A[i] <= B[j])
                A[total++] = A[i++];
            else
                A[total++] = B[j++];
        }
        while (i < A.length) A[total++] = A[i++];
        while (j < n) A[total++] = B[j++];
    }
}
