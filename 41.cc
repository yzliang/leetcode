class Solution {
public:
    int firstMissingPositive(int A[], int n) {
        int num_pos = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] > 0) {
                int temp = A[i];
                A[i] = A[num_pos];
                A[num_pos++] = temp;
            }
        }
        for (int i = 0; i < num_pos; i++) {
            while (A[i] <= num_pos && A[A[i] - 1] != A[i]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        for (int i = 0; i < num_pos; i++) {
            if (A[i] != i + 1) return i + 1;
        }
        return num_pos + 1;
    }
};
