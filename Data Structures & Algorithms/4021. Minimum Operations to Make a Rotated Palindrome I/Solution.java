class Solution {
    public int minOperations(String s) {
        int minCost = Integer.MAX_VALUE;
        int n = s.length();
        int m = n / 2;

        for (int k = 0; k < n; k++) {
            int currCost = k;

            for (int i = 0; i < m; i++) {
                int l = (k + i) % n;
                int r = (n-i-1+k) % n;

                char ch1 = s.charAt(l);
                char ch2 = s.charAt(r);

                if (ch1 != ch2) {
                    int diff1 = (ch1 - ch2 + 26) % 26;
                    int diff2 = (ch2 - ch1 + 26) % 26;

                    currCost += Math.min(diff1, diff2);
                }
            }

            minCost = Math.min(minCost, currCost);
        }

        return minCost;
    }
}
