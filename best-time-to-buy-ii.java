public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1])
                ans += prices[i + 1] - prices[i];
        }
        return ans;
    }
}
