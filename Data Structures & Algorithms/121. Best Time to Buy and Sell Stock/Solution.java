// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, maxProfit = 0;
        int n = prices.length;
        int l = 0, r = 1;

        while (r < n) {
            profit = prices[r] - prices[l];
            if (profit > 0) {
                maxProfit = Math.max(maxProfit, profit);
            } else {
                l = r;
            }
            r++;
        }

        return maxProfit;
    }
}
