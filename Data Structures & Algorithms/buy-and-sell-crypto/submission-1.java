class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        if (prices.length < 2) {
            return maxProfit;
        }

        int minPrice = 1001;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }

            int currentProfit = price - minPrice;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }

        return maxProfit;
    }
}
