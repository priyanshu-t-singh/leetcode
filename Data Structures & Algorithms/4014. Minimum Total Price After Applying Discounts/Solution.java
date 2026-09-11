class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int n = prices.length;
        int m = discounts.length;

        double total = 0;
        for (int i = n-1, j = m-1; i >= 0; i--, j--) {
            if (j >= 0) {
                total += prices[i] * (100 - discounts[j]) / (double) 100;
            } else {
                total += prices[i];
            }
        }
        return total;
    }
}
