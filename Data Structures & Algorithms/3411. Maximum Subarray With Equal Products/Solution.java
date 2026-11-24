// Time Complexity: O(n^2)
// Space Complexity: O(1)
class Solution {
    public int maxLength(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            long prod = nums[i];
            long gcd = nums[i];
            long lcm = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                prod *= nums[j];
                gcd = gcd(gcd, nums[j]);
                lcm = (lcm * nums[j]) / gcd(lcm, nums[j]);

                if (prod > gcd * lcm) {
                    break;
                }

                if (prod == gcd * lcm) {
                    result = Math.max(result, j-i+1);
                }
            }
        }

        return result;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
