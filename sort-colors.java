public class Solution {
    public void sortColors(int[] A) {
        int red = 0;
        int blue = A.length - 1;
        int i = 0;
        while (i <= blue) {
            if (A[i] == 0) {
                if (i == red) {
                    i++;
                    red++;
                } else {
                    A[red++] = 0;
                    A[i++] = 1;
                }
            } else if (A[i] == 1) {
                i++;
            } else {
                A[i] = A[blue];
                A[blue--] = 2;
            }
        }
    }
}
