class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;

        int l = 0;
        int max = 0;

        for (int r = 1; r < prices.length; r++) {
            int profit = prices[r] - prices[l];
            max = Math.max(max, profit);
            if (prices[r] < prices[l]) {
                l = r;
            }
        }

        return max;
    }
}
