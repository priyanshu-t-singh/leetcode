// Time Complexity: O(n * log(max(piles)))
// Space Complexity: O(1)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1, high = piles[0];
        for (int i = 0; i < n; i++) {
            high = Math.max(high, piles[i]);
        }

        int k = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            int time = 0;
            for (int i = 0; i < n; i++) {
                time += Math.ceil((double) piles[i] / mid);
                if (time > h) {
                    break;
                }
            }

            if (time <= h) {
                k = Math.min(k, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return k;
    }
}
