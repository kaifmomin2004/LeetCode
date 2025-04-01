// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

public class lc0121 {
    public static void main(String[] args) {
        int[] prices = { 2, 4, 1 };
        System.out.println(maxProfit(prices)); // Should print 2
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int minPrice = prices[0]; // Track the lowest price so far
        int maxProfit = 0; // Track the maximum profit so far

        for (int i = 1; i < prices.length; i++) {
            // Check if selling today yields a better profit than what we have so far
            int profitIfSellToday = prices[i] - minPrice;
            if (profitIfSellToday > maxProfit)
                maxProfit = profitIfSellToday;

            // Update the minPrice if the current price is lower
            if (prices[i] < minPrice)
                minPrice = prices[i];
        }
        return maxProfit;
    }
}