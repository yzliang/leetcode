public class Solution {
    public int singleNumber(int[] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++)
            ans = ans ^ A[i];
        return ans;
    }
}
