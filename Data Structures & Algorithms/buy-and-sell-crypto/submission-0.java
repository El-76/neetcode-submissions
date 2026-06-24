class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        if (prices.length < 2) {
            return profit;
        }

        int b = 0;
        int s = 0;

        for (int i = 1; ; i++) {
            if (b < s) {
                int currentProfit = prices[s] - prices[b];
                if (currentProfit > profit) {
                    profit = currentProfit;
                }
            }

            if (i == prices.length) {
                break;
            }

            if (prices[i] < prices[b]) {
                b = i;
                s = i;
            }

            if (prices[i] > prices[s]) {
                s = i;
            }
        }

        return profit;
    }
}
