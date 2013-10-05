public class Solution {
    char[] c10 = {'I', 'X', 'C', 'M'};
    char[] c5 = {'V', 'L', 'D'};

    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        int pos = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit <= 3) {
                for (int i = 0; i < digit; i++)
                    ans.append(c10[pos]);
            } else if (digit == 4) {
                ans.append(c5[pos]);
                ans.append(c10[pos]);
            } else if (digit <= 8) {
                for (int i = 6; i <= digit; i++)
                    ans.append(c10[pos]);
                ans.append(c5[pos]);
            } else {
                ans.append(c10[pos + 1]);
                if (digit == 9) ans.append(c10[pos]);
            }
            num /= 10;
            pos++;
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String args[]) {
        new Solution().intToRoman(3173);
    }
}
