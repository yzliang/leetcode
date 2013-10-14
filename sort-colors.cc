class Solution {
public:
    void sortColors(int A[], int n) {
        int end_pos = partition_color(A, 0, n, 0);
        end_pos = partition_color(A, end_pos + 1, n, 1);
    }
    
    int partition_color(int A[], int start_pos, int n, int color) {
        int end_pos = start_pos - 1;
        for (int i = start_pos; i < n; i++) {
            if (A[i] == color) {
                end_pos++;
                int temp = A[i];
                A[i] = A[end_pos];
                A[end_pos] = temp;
            }
        }
        return end_pos;
    }
};
