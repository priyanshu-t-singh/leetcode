// Time Complexity: O(t * log(n))
// Space Complexity: O(1)
class Solution {
    public int smallestNumber(int n, int t) {
        for (int i = 0; i < t; i++) {
            int tmp = n + i;
            int product = 1;

            while (tmp > 0) {
                int digit = tmp % 10;
                product *= digit;
                tmp /= 10;
            }

            if (product % t == 0) {
                return n + i;
            }
        }

        return n + t - 1;
    }
}
