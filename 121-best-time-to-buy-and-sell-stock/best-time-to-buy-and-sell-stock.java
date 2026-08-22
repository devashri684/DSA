class Solution {
    public int maxProfit(int[] prices) {
    

        int minPrice = prices[0];
        int maximumProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            int currentProfit = prices[i] - minPrice;

            maximumProfit = Math.max(maximumProfit, currentProfit);

            minPrice = Math.min(minPrice, prices[i]);
        }

        return maximumProfit;
    }
}