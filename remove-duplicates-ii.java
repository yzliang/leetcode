public class Solution {
    public int removeDuplicates(int[] A) {
        int total = 0;
        int i = 0;
        while (i < A.length) {
            int j = i + 1;
            while (j < A.length && A[j] == A[i]) j++;
            A[total++] = A[i];
            if (j - i > 1) A[total++] = A[i];
            i = j;
        }
        return total;
    }
}
