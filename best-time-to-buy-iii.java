public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] bestBefore = new int[prices.length];
        int minPrice = prices[0];
        bestBefore[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            bestBefore[i] = Math.max(bestBefore[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        int[] bestAfter = new int[prices.length];
        int maxPrice = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            bestAfter[i] = Math.max(bestAfter[i + 1], maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (bestBefore[i] + bestAfter[i] > ans)
                ans = bestBefore[i] + bestAfter[i];
        }
        return ans;
    }
}
