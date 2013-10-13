public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0 && carry > 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        if (carry > 0) {
            int[] ans = new int[digits.length + 1];
            for (int i = 0; i < digits.length; i++)
                ans[i + 1] = digits[i];
            ans[0] = carry;
            return ans;
        }
        return digits;
    }
}
